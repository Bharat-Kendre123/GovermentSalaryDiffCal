package employee.styling;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import employee.models.SalaryCalculatonDuraton;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 4/1/19
 * Time: 5:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class UtilForJulyIncrement {


    public static void main(String[] x)

    {
        List<SalaryCalculatonDuraton> list =getListOnBasisOfJulyIncrementYeary(15,1,2015,15,1,2016,13,2,2019);
        System.out.println("HI BHARAT");
    }

    public static List<SalaryCalculatonDuraton> getListOnBasisOfJulyIncrementYeary(int jDay,int jMonth,int jYear,int fromDay,int fromMonth,int fromYear,int toDay,int toMonth,int toYear )
    {
        int tempFromDay=fromDay;
        int tempToYear=toYear;
        int tempFromMonth=fromMonth;
        int tempToMonth=toMonth;
        List<SalaryCalculatonDuraton> salaryCalculatonDuratons=new ArrayList<>();

        /* FFIRST STEP OF CALCULATING JULY INCREMENT EMPLOYEE LLIST IS TOO SPLIT THE INPUT EEMPLYEE
            DETAIL INTO YEAR LIST
            */
        for(int year=fromYear;year<=toYear;year++)
        {
            if(year==toYear)  // LAST STEP OR FIRST ITERATION
            {
                salaryCalculatonDuratons.add(new SalaryCalculatonDuraton(tempFromDay,tempFromMonth,year,toDay,tempToMonth,tempToYear));
            } else{           // FIRST OR MID ITERATONS
                YearMonth lengthOfMonth= YearMonth.of(year,12);  //calculated lenght of month in days
                salaryCalculatonDuratons.add(new SalaryCalculatonDuraton(tempFromDay,tempFromMonth,year,lengthOfMonth.lengthOfMonth(),12,year)) ;
                tempFromMonth =1;
                tempFromDay =1;
            }

        }

       return decideExactIncrementlock( jDay, jMonth, jYear,decideIncrementalBlock(getListOnBasisOfJulyIncrementHalfYearly(salaryCalculatonDuratons)));
    }


    public static List<SalaryCalculatonDuraton> getListOnBasisOfJulyIncrementHalfYearly(List<SalaryCalculatonDuraton> salaryCalculatonDuratons)
    {

        List<SalaryCalculatonDuraton> halfYearlylist = new ArrayList<>();

        if(salaryCalculatonDuratons.size()==1)   // SIGLE OBJECT SPLIT LOGIC
        {
            SalaryCalculatonDuraton temp= salaryCalculatonDuratons.get(0);
            if(temp.getFromMonth()>6 ||  temp.getToMonth()<=6)
            {
                halfYearlylist.add(temp);
            }  else{
                int junesLastDay= YearMonth.of(temp.getToYear(),6).lengthOfMonth();
                halfYearlylist.add(new SalaryCalculatonDuraton(temp.getFromDay(),temp.getFromMonth(),temp.getFromYear(),junesLastDay,6,temp.getToYear()));
                halfYearlylist.add(new SalaryCalculatonDuraton(1,7,temp.getFromYear(),temp.getToDay(),temp.getToMonth(),temp.getToYear()));
            }
        } else{
              int size =salaryCalculatonDuratons.size();
               int lastElement =size-1;
                int counter =0;
            for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
            {

                if(counter==0)  // first element logic
                {
                    if(salaryCalculatonDuraton.getFromMonth()>6)
                    {
                        halfYearlylist.add(salaryCalculatonDuraton);
                    }else{
                        int junesLastDay= YearMonth.of(salaryCalculatonDuraton.getToYear(),6).lengthOfMonth();
                        int decLastDay= YearMonth.of(salaryCalculatonDuraton.getToYear(),12).lengthOfMonth();
                        halfYearlylist.add(new SalaryCalculatonDuraton(salaryCalculatonDuraton.getFromDay(),salaryCalculatonDuraton.getFromMonth(),salaryCalculatonDuraton.getFromYear(),junesLastDay,6,salaryCalculatonDuraton.getToYear()));
                        halfYearlylist.add(new SalaryCalculatonDuraton(1,7,salaryCalculatonDuraton.getFromYear(),decLastDay,12,salaryCalculatonDuraton.getToYear()));
                    }

                } else  if(counter==lastElement)
                {
                    if(salaryCalculatonDuraton.getToMonth()<=6)
                    {
                       halfYearlylist.add(salaryCalculatonDuraton);
                    } else{
                        int junesLastDay= YearMonth.of(salaryCalculatonDuraton.getToYear(),6).lengthOfMonth();
                        halfYearlylist.add(new SalaryCalculatonDuraton(1,1,salaryCalculatonDuraton.getFromYear(),junesLastDay,6,salaryCalculatonDuraton.getToYear()));
                        halfYearlylist.add(new SalaryCalculatonDuraton(1,7,salaryCalculatonDuraton.getFromYear(),salaryCalculatonDuraton.getToDay(),salaryCalculatonDuraton.getToMonth(),salaryCalculatonDuraton.getToYear()));
                    }

                }   else{
                    int junesLastDay= YearMonth.of(salaryCalculatonDuraton.getToYear(),6).lengthOfMonth();
                    int decLastDay= YearMonth.of(salaryCalculatonDuraton.getToYear(),salaryCalculatonDuraton.getToMonth()).lengthOfMonth();
                    halfYearlylist.add(new SalaryCalculatonDuraton(1,1,salaryCalculatonDuraton.getFromYear(),junesLastDay,6,salaryCalculatonDuraton.getToYear()));
                    halfYearlylist.add(new SalaryCalculatonDuraton(1,7,salaryCalculatonDuraton.getFromYear(),decLastDay,salaryCalculatonDuraton.getToMonth(),salaryCalculatonDuraton.getToYear()));
                }
                 counter++;
            }

    }

        return halfYearlylist;
    }


    public static  List<SalaryCalculatonDuraton> decideIncrementalBlock(List<SalaryCalculatonDuraton> salaryCalculatonDuratons)
    {
        List<SalaryCalculatonDuraton> salaryCalculatonDuratons1  = new ArrayList<>();
        int counter =0;
        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
            if(counter!=0&&salaryCalculatonDuraton.getFromMonth()>6)
            {
                salaryCalculatonDuraton.setIncrement(true);
                salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
            } else {
                salaryCalculatonDuraton.setIncrement(false);
                salaryCalculatonDuratons1.add(salaryCalculatonDuraton) ;
            }
            counter++;
        }
        return  salaryCalculatonDuratons1;
    }

    public static List<SalaryCalculatonDuraton> decideExactIncrementlock(int jDay,int jMonth,int jYear,List<SalaryCalculatonDuraton> salaryCalculatonDuratons)
    {
        List<SalaryCalculatonDuraton> salaryCalculatonDuratons1  = new ArrayList<>();

        for(SalaryCalculatonDuraton salaryCalculatonDuraton:salaryCalculatonDuratons)
        {
               if(salaryCalculatonDuraton.isIncrement() && salaryCalculatonDuraton.getFromYear()>jYear)
               {
                   salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
               }else if(salaryCalculatonDuraton.isIncrement() && (salaryCalculatonDuraton.getFromYear()==jYear)){

                    if(jMonth>1 || (jMonth==1 && jDay!=1)){
                        salaryCalculatonDuraton.setIncrement(false);
                        salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
                    }else{
                        salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
                    }
               }else{
                   salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
               }
        }
        return  salaryCalculatonDuratons1;
    }
}


