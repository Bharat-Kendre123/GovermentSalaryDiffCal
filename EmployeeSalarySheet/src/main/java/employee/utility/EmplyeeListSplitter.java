package employee.utility;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import employee.models.Employee;
import employee.models.SalaryComponenets;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 4/14/19
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmplyeeListSplitter {

    /* just separate the month witch is incomplete*/
    public static List<Employee> getSplittedList(List<Employee> employeeList)
    {
       List<Employee> employees = new ArrayList<>();
        for(Employee employee:employeeList)
        {
             if(employee.isInComplete())
             {
                     if(employee.isStartMonthNotCompelete() && employee.isEndMonthNotCompelete())
                     {
                         employees.addAll(getStartAndEndMonthIncompList(employee)) ;
                     }else if(employee.isStartMonthNotCompelete())
                     {
                         employees.addAll(getStartMonthIncList(employee));
                     }else{
                         employees.addAll(getEndMonthIncmList(employee));
                     }
             }else{
                 employees.add(employee);
             }
        }
       return employees;
    }

    private static Collection<? extends Employee> getEndMonthIncmList(Employee employee) {
        int fromDay =employee.getFromDay();
        int fromMonth =employee.getFromMonth();
        int toDay =employee.getToDay();
        int toMonth =employee.getToMonth();
        List<Employee> splittedList = new ArrayList<>();

        if(fromMonth==toMonth){
            int noOfDaysWorked= toDay-fromDay+1;
            int totalDaysOfTofMonth= YearMonth.of(employee.getFromYear(),fromMonth).lengthOfMonth();
            employee.setMonthFlag(true);
            splittedList.add(getExcactSalaryForThisDuration(employee,noOfDaysWorked,totalDaysOfTofMonth));
        }else{
            int totalDaysOfTofMonth= YearMonth.of(employee.getFromYear(),toMonth-1).lengthOfMonth();
            employee.setToDay(totalDaysOfTofMonth);
            employee.setToMonth(toMonth-1);
            splittedList.add(employee);

            int totalNoOfDays= YearMonth.of(employee.getFromYear(),toMonth).lengthOfMonth();
            Employee e1  =  shallowClonning(employee,1,toMonth,employee.getFromYear(),toDay,toMonth,employee.getToYear());
            splittedList.add(getExcactSalaryForThisDuration(e1,toDay,totalNoOfDays));

        }
        return splittedList;
    }

    private static Collection<? extends Employee> getStartMonthIncList(Employee employee) {
        int fromDay =employee.getFromDay();
        int fromMonth =employee.getFromMonth();
        int toDay =employee.getToDay();
        int toMonth =employee.getToMonth();
        List<Employee> splittedList = new ArrayList<>();
        int totalDaysOFromfMonth= YearMonth.of(employee.getFromYear(),fromMonth).lengthOfMonth();
        int noOfDaysWorkFromMonth= totalDaysOFromfMonth- employee.getFromDay()+1;
        Employee e1 = shallowClonning(employee,fromDay,fromMonth,employee.getFromYear(),totalDaysOFromfMonth,fromMonth,employee.getFromYear());
        splittedList.add(getExcactSalaryForThisDuration(e1,noOfDaysWorkFromMonth,totalDaysOFromfMonth));

        // directly set the other part of employee. Just set the from date part
        employee.setFromDay(1);
        employee.setFromMonth(fromMonth+1);
        splittedList.add(employee);
        return splittedList;

    }

    private static Collection<? extends Employee> getStartAndEndMonthIncompList(Employee employee) {

        int fromDay =employee.getFromDay();
        int fromMonth =employee.getFromMonth();
        int toDay =employee.getToDay();
        int toMonth =employee.getToMonth();

        List<Employee> splittedList = new ArrayList<>();
        if(fromMonth==toMonth)
        {
            int totalDaysOfMonth= YearMonth.of(employee.getFromYear(),toMonth).lengthOfMonth();
            int noOfDaysWorked = toDay-fromDay+1;
            splittedList.add(getExcactSalaryForThisDuration(employee,noOfDaysWorked,totalDaysOfMonth));
        }else if(toMonth-fromMonth==1){
            int totalDaysOFromfMonth= YearMonth.of(employee.getFromYear(),fromMonth).lengthOfMonth();
            int noOfDaysWorkFromMonth= totalDaysOFromfMonth- employee.getFromDay()+1;
            Employee e1 = shallowClonning(employee,employee.getFromDay(),employee.getFromMonth(),employee.getFromYear(),totalDaysOFromfMonth,employee.getFromMonth(),employee.getFromYear());
            splittedList.add(getExcactSalaryForThisDuration(e1,noOfDaysWorkFromMonth,totalDaysOFromfMonth));


            int totalDaysOFromfToMonth= YearMonth.of(employee.getFromYear(),toMonth).lengthOfMonth();
            int noOfDaysWorkToMonth= employee.getToDay();
            Employee e2=shallowClonning(employee,1,employee.getToMonth(),employee.getToYear(),employee.getToDay(),employee.getToMonth(),employee.getToYear()) ;
            splittedList.add(getExcactSalaryForThisDuration(e2,noOfDaysWorkToMonth,totalDaysOFromfToMonth)) ;

        } else if(toMonth-fromMonth>1)
        {
            int totalDaysOFromfMonth= YearMonth.of(employee.getFromYear(),fromMonth).lengthOfMonth();
            int noOfDaysWorkFromMonth= totalDaysOFromfMonth- employee.getFromDay()+1;
            Employee e1 = shallowClonning(employee,employee.getFromDay(),employee.getFromMonth(),employee.getFromYear(),totalDaysOFromfMonth,employee.getFromMonth(),employee.getFromYear());
            splittedList.add(getExcactSalaryForThisDuration(e1,noOfDaysWorkFromMonth,totalDaysOFromfMonth));

            // adjust middlle of employee. need to adjust duration part
             int fday =1;
            int fMonth=fromMonth+1;
            int toMonthsNoOfDay =YearMonth.of(employee.getFromYear(),toMonth).lengthOfMonth();
            int tMonth = toMonth-1;
            employee.setFromDay(fday);
            employee.setFromMonth(fMonth);
            employee.setToDay(toMonthsNoOfDay);
            employee.setToMonth(tMonth);
            splittedList.add(employee);

            int totalDaysOFromfToMonth= YearMonth.of(employee.getFromYear(),toMonth).lengthOfMonth();
            int noOfDaysWorkToMonth= employee.getToDay();
            Employee e2=shallowClonning(employee,1,employee.getToMonth(),employee.getToYear(),employee.getToDay(),employee.getToMonth(),employee.getToYear());
            splittedList.add(getExcactSalaryForThisDuration(e2,noOfDaysWorkToMonth,totalDaysOFromfToMonth)) ;
        }

     return  splittedList;
    }

    private static Employee getExcactSalaryForThisDuration(Employee temp, int noOfDaysWorked,int totalDaysOfMonth) {

        temp.setAdmissibleSalary(getSalaryForDays(temp.getAdmissibleSalary(), noOfDaysWorked, totalDaysOfMonth));
        temp.setDrawnSalary(getSalaryForDays(temp.getDrawnSalary(),noOfDaysWorked,totalDaysOfMonth));
        temp.setDiff(getSalaryForDays(temp.getDiff(),noOfDaysWorked,totalDaysOfMonth));
        return temp;
    }

    public static SalaryComponenets getSalaryForDays(SalaryComponenets ori,int noOfDaysWorked, int totalDaysOfMonth)               //orii referes original
    {
        SalaryComponenets temp= new SalaryComponenets();
        temp.setBasicPay(divideSalaryComponent(ori.getBasicPay(), noOfDaysWorked,totalDaysOfMonth));
        temp.setGradepay(divideSalaryComponent(ori.getGradepay(), noOfDaysWorked,totalDaysOfMonth));
        temp.setTa(divideSalaryComponent(ori.getTa(), noOfDaysWorked,totalDaysOfMonth));
        temp.setCaAndOtherA(divideSalaryComponent(ori.getCaAndOtherA(), noOfDaysWorked, totalDaysOfMonth));
        temp.setWa(divideSalaryComponent(ori.getWa(), noOfDaysWorked,totalDaysOfMonth));
        temp.setDcps(divideSalaryComponent(ori.getDcps(), noOfDaysWorked,totalDaysOfMonth));
        //temp.setCla(divideSalaryComponent(ori.getCla(), noOfDaysWorked,totalDaysOfMonth));
        temp.setHra(divideSalaryComponent(ori.getHra(),noOfDaysWorked,totalDaysOfMonth));
        temp.setDa(divideSalaryComponent(ori.getDa(),noOfDaysWorked,totalDaysOfMonth));
        temp.setNpa(divideSalaryComponent(ori.getNpa(),noOfDaysWorked,totalDaysOfMonth));
        return temp;
    }

    public static int divideSalaryComponent(int compenent,float divisionNUmber,float totalDaysOfMonth)
    {
        return Math.round((compenent*divisionNUmber)/totalDaysOfMonth);
    }



    public static Employee shallowClonning(Employee e,int fDay,int fMonth,int fYear, int toDay,int toMonth, int toYear)
    {
        Employee employee = new Employee();
        employee.setAdmissibleSalary(getClonedSalary(e.getAdmissibleSalary()));
        employee.setDrawnSalary(getClonedSalary(e.getDrawnSalary()));
        employee.setDiff(getClonedSalary(e.getDiff()));
        employee.setFromDay(fDay);
        employee.setFromMonth(fMonth);
        employee.setFromYear(fYear);
        employee.setToDay(toDay);
        employee.setToMonth(toMonth);
        employee.setToYear(toYear);
        employee.setInComplete(e.isInComplete());
        employee.setStartMonthNotCompelete(e.isStartMonthNotCompelete());
        employee.setEndMonthNotCompelete(e.isEndMonthNotCompelete());

        // month flag to add exact date in month column of sheet
        employee.setMonthFlag(true);
        return employee;

    }

    private static SalaryComponenets getClonedSalary(SalaryComponenets ori) {
        SalaryComponenets temp = new SalaryComponenets();
        temp.setBasicPay(ori.getBasicPay());
        temp.setGradepay(ori.getGradepay());
        temp.setTa(ori.getTa());
        temp.setCaAndOtherA(ori.getCaAndOtherA());
        temp.setWa(ori.getWa());
        temp.setDcps(ori.getDcps());
      //  temp.setCla(ori.getCla());
        temp.setHra(ori.getHra());
        temp.setDa(ori.getDa());
        temp.setNpa(ori.getNpa());
        return temp;
    }
}
