package employee.utility;

import employee.data.PayBandMapObject;
import employee.data.SalaryData;
import employee.models.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 3/30/19
 * Time: 4:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Util {


    public static Map<Integer, int[]> gradePayMap = new HashMap();

    static {
        gradePayMap.put(1300, SalaryData.s1);
        gradePayMap.put(1400, SalaryData.s2);
        gradePayMap.put(1600, SalaryData.s3);
        gradePayMap.put(1650, SalaryData.s4);
        gradePayMap.put(1700, SalaryData.s4);
        gradePayMap.put(1800, SalaryData.s5);
        gradePayMap.put(1900, SalaryData.s6);
        gradePayMap.put(2000, SalaryData.s7);
        gradePayMap.put(2400, SalaryData.s8);
        gradePayMap.put(2500, SalaryData.s9);
        gradePayMap.put(2800, SalaryData.s10);
        gradePayMap.put(2900, SalaryData.s11);
        gradePayMap.put(3000, SalaryData.s11);
        gradePayMap.put(3500, SalaryData.s12);
        gradePayMap.put(4100, SalaryData.s13);
        gradePayMap.put(4200, SalaryData.s13);
        gradePayMap.put(4300, SalaryData.s14);
        gradePayMap.put(4400, SalaryData.s15);
        gradePayMap.put(4500, SalaryData.s16);
        gradePayMap.put(4600, SalaryData.s16);
        gradePayMap.put(4800, SalaryData.s17);
        gradePayMap.put(4900, SalaryData.s18);
        gradePayMap.put(5000, SalaryData.s18);
        gradePayMap.put(5400, SalaryData.s20);
        gradePayMap.put(5500, SalaryData.s21);
        gradePayMap.put(5700, SalaryData.s22);
        gradePayMap.put(5800, SalaryData.s22);
        gradePayMap.put(6600, SalaryData.s23);
        gradePayMap.put(6900, SalaryData.s24);
        gradePayMap.put(7600, SalaryData.s25);
        gradePayMap.put(7900, SalaryData.s26);
        gradePayMap.put(8700, SalaryData.s27);
        gradePayMap.put(8800, SalaryData.s28);
        gradePayMap.put(8900, SalaryData.s29);
        gradePayMap.put(1000, SalaryData.s30);
        gradePayMap.put(67000, SalaryData.s30);

    }


    public static int getAdmissibleBasicForPromotion(int oldAdmissibleBasic, String payBand, boolean doDoublencrement)  // doubleincrement= true to do the 2 increments.
    {
        int[] data = PayBandMapObject.payBandLevelArrayMaping.get(payBand);
        int counter = 0;
        for (int i : data) {
            if (oldAdmissibleBasic == i)
                break;
            counter++;
        }
        if (doDoublencrement) {
            counter = counter + 2;
        } else {
            counter = counter + 1;
        }
        return data[counter];
    }

    public static int getAdmissibleBasicPay(int basic6PaySalary, int gradepayOf6, String key) {
        int salary = (int) Math.round(((basic6PaySalary + gradepayOf6) * 2.57));

        int reminderUpTo100Place = salary % 100;
        if (reminderUpTo100Place > 50) {
            salary = salary + (100 - reminderUpTo100Place);
        } else {
            salary = salary - reminderUpTo100Place;
        }

        int new7PaySalary = 0;
        int[] i = PayBandMapObject.payBandLevelArrayMaping.get(key);
        if (i == null) {
            i = PayBandMapObject.payBandLevelArrayMaping.get(67000);
        }
        for (int data : i) {
            if (salary == data || salary < data) {
                new7PaySalary = data;
                break;
            }
        }
        return new7PaySalary;
    }


    public static int getAdmissibleBasicPayForManualInput(int admissibleBasic, String key) {


        int reminderUpTo100Place = admissibleBasic % 100;
        if (reminderUpTo100Place > 50) {
            admissibleBasic = admissibleBasic + (100 - reminderUpTo100Place);
        } else {
            admissibleBasic = admissibleBasic - reminderUpTo100Place;
        }

        int new7PaySalary = 0;
        int[] i = PayBandMapObject.payBandLevelArrayMaping.get(key);
        if (i == null) {
            i = PayBandMapObject.payBandLevelArrayMaping.get(67000);
        }
        for (int data : i) {
            if (admissibleBasic == data || admissibleBasic < data) {
                new7PaySalary = data;
                break;
            }
        }
        return new7PaySalary;
    }

    public static int getLevelFor7thPay(int basic6PaySalary, int gradepayOf6, String key) {
        int salary = (int) Math.round(((basic6PaySalary + gradepayOf6) * 2.57));
        int new7PaySalary = 0;
        int[] i = PayBandMapObject.payBandLevelArrayMaping.get(key);
        if (i == null) {
            i = PayBandMapObject.payBandLevelArrayMaping.get(67000);
        }
        int counter = 0;
        for (int data : i) {
            counter++;
            if (salary == data || salary < data) {
                break;
            }
        }
        return counter;
    }

    public static int getLevelFor7thPayForAdmissibleBasicPayInput(int basic7PaySalary,String key) {
        int salary = basic7PaySalary;

        int[] i = PayBandMapObject.payBandLevelArrayMaping.get(key);
        if (i == null) {
            i = PayBandMapObject.payBandLevelArrayMaping.get(67000);
        }
        int counter = 0;
        int level=0;

        for (int data : i) {
            counter++;
            if (salary == data || salary < data) {
                level=counter;
                break;
            }
            if(i.length == counter){
                level=-1;
            }
        }

        return level;
    }

    public static int getHRA(int per, int salary) {
        return ((int) Math.round(salary * per / 100.0));
    }

    public static int getHRA7(int per, int salary) {

        return per <= 0 ? 0 : ((int) Math.round(salary * per / 100.0)) < 1800 ? 1800 : (int) Math.round(salary * per / 100.0);
    }

    public static int getDCPS(int salary) {
        return (int) Math.round(salary * 10 / 100.0);
    }

    public static int getAdmissibeDA(int basicPay, int year, int month) {
        int admissibeda = 0;
        if (year == 2016) {
            if (month <= 6) {
                admissibeda = 0;
            } else {
                admissibeda = (int) Math.round(basicPay * 2 / 100.0);
            }

        } else if (year == 2017) {
            if (month <= 6) {
                admissibeda = (int) Math.round(basicPay * 4 / 100.0);
            } else {
                admissibeda = (int) Math.round(basicPay * 5 / 100.0);
            }
        } else if (year == 2018) {
            if (month <= 6) {
                admissibeda = (int) Math.round(basicPay * 7 / 100.0);
            } else {
                admissibeda = (int) Math.round(basicPay * 9 / 100.0);
            }
        } else {
            admissibeda = (int) Math.round(basicPay * 9 / 100.0);
        }
        return admissibeda;
    }


    public static int getDrawnDa(int basicPay, int year, int month) {

        int drawanDa = 0;
        if (year == 2016) {
            if (month <= 6) {
                drawanDa = (int) Math.round(basicPay * 125 / 100.0);
            } else {
                drawanDa = (int) Math.round(basicPay * 132 / 100.0);
            }

        } else if (year == 2017) {
            if (month <= 6) {
                drawanDa = (int) Math.round(basicPay * 136 / 100.0);
            } else {
                drawanDa = (int) Math.round(basicPay * 139 / 100.0);
            }
        } else if (year == 2018) {
            if (month <= 6) {
                drawanDa = (int) Math.round(basicPay * 142 / 100.0);
            } else {
                drawanDa = (int) Math.round(basicPay * 142 / 100.0);
            }
        } else {
            drawanDa = (int) Math.round(basicPay * 142 / 100.0);
        }
        return drawanDa;
    }

    public static boolean isDSCP(String dcpsinput) {
        return "YES".equalsIgnoreCase(dcpsinput) ? true : false;
    }

    //calcuulate NPA

    public static int[] calculateNPA(String npaFlag, int basic6thsalary, int gradePay, int basic7thsalary, String nap7th)     // here salary = basiic + GP
    {
        int[] nap = new int[2];
        int npa6 = 0;
        int npa7 = 0;
        if ("YES".equalsIgnoreCase(npaFlag)) {
            npa6 = (int) Math.round((basic6thsalary + gradePay) * 35 / 100.0);
            try {
                npa7 = (int) Math.round((basic7thsalary) * Integer.parseInt(nap7th) / 100.0);
            } catch (Exception e) {
                npa7 = npa6;
            }

        } else {
            return nap;
        }
        nap[0] = npa6;
        nap[1] = npa7;
        return nap;
    }


    public static boolean isIncrementAppcablleForJan(int jday, int jmonth, int jyear, int financialYear, int attempt) {
        if (attempt == 1) {
            return false;
        } else {
            int tempForMonth = jmonth + 5;
            if (tempForMonth < 12 && jyear < financialYear) {
                return true;
            } else if (tempForMonth == 12 && jyear < financialYear) {
                if (jday == 1) {
                    return true;
                } else {
                    return jyear + 1 < financialYear ? true : false;
                }
            } else {
                return jyear + 1 < financialYear ? true : false;
            }
        }

    }

    public static int roundOffIncrement(int increment) {
        int incrementAmount = increment;
        int reminder = increment % 10;
        if (reminder != 0) {
            incrementAmount = increment + (10 - reminder);
        }
        return incrementAmount;
    }

    public static boolean isIncrementAppcablleForJuly(int jday, int jmonth, int jyear, int financialYear, int attempt) {
        if (attempt == 1) {
            return false;
        } else {
            int tempForMonth = jmonth + 6;
            if (tempForMonth < 12 && jyear < financialYear) {
                return true;
            } else if (tempForMonth == 12 && jyear < financialYear) {
                if (jday == 1) {
                    return true;
                } else {
                    return jyear + 1 < financialYear ? true : false;
                }
            } else {
                return jyear + 1 < financialYear ? true : false;
            }
        }

    }


    public static int[] getEmplyeeDataColumnwise(Employee employeeSheet, int length) {
        int[] data = new int[length];
        data[0] = 1;
        data[1] = 0;
        data[2] = employeeSheet.getAdmissibleSalary().getBasicPay();
        data[3] = employeeSheet.getAdmissibleSalary().getDa();
        data[4] = employeeSheet.getAdmissibleSalary().getTa();
        data[5] = employeeSheet.getAdmissibleSalary().getCaAndOtherA();
        data[6] = employeeSheet.getAdmissibleSalary().getWa();
        data[7] = employeeSheet.getAdmissibleSalary().getHra();
        data[8] = employeeSheet.getAdmissibleSalary().getNpa();
        data[9] = data[2] + data[3] + data[4] + data[5] + data[6] + data[7] + data[8];
        data[10] = 0;
        data[11] = employeeSheet.getAdmissibleSalary().getDcps();
        data[12] = employeeSheet.getDrawnSalary().getBasicPay();
        data[13] = employeeSheet.getDrawnSalary().getGradepay();
        data[14] = employeeSheet.getDrawnSalary().getDa();
        data[15] = employeeSheet.getDrawnSalary().getTa();
        data[16] = employeeSheet.getDrawnSalary().getCaAndOtherA();
        data[17] = employeeSheet.getDrawnSalary().getWa();
        data[18] = employeeSheet.getDrawnSalary().getHra();
        data[19] = employeeSheet.getDrawnSalary().getNpa();
        data[20] = data[12] + data[13] + data[14] + data[15] + data[16] + data[17] + data[18] + data[19];
        data[21] = 0;
        data[22] = employeeSheet.getDrawnSalary().getDcps();
        data[23] = employeeSheet.getDiff().getBasicPay();
        data[24] = employeeSheet.getDiff().getDa();
        data[25] = employeeSheet.getDiff().getTa();
        data[26] = employeeSheet.getDiff().getCaAndOtherA();
        data[27] = employeeSheet.getDiff().getWa();
        data[28] = employeeSheet.getDiff().getHra();
        data[29] = employeeSheet.getDiff().getNpa();
        data[30] = data[23] + data[24] + data[25] + data[26] + data[27] + data[28] + data[29];
        data[31] = 0;
        data[32] = employeeSheet.getDiff().getDcps();
        data[33] = data[30];
        return data;

    }


    public static int[] getInstallmentAmount(int totalAmount) {
        int reminder = totalAmount % 5;
        int installmentAmount = (totalAmount - reminder) / 5;
        return new int[]{installmentAmount, installmentAmount, installmentAmount, installmentAmount, installmentAmount + reminder};
    }

    public static void setDuratonStatement(List<Employee> employeeSheetList) {
        int fromMonthTital2019 = 1;
        int fromYearTital2019 = 1;
        int toMonthTital2019 = 1;
        int toYearTital2019 = 2019;
        int fromMonthTital2016_18 = 1;
        int fromYearTital2016_18 = 1;
        int toMonthTital2016_18 = 1;
        int toYearTital2016_18 = 1;

        if (employeeSheetList.get(employeeSheetList.size() - 1).getToYear() == 2019) {
            fromMonthTital2019 = 1;
            fromYearTital2019 = 2019;
            toMonthTital2019 = employeeSheetList.get(employeeSheetList.size() - 1).getToMonth();
            toYearTital2019 = 2019;
            fromMonthTital2016_18 = employeeSheetList.get(0).getFromMonth();
            fromYearTital2016_18 = employeeSheetList.get(0).getFromYear();
            toMonthTital2016_18 = 12;
            toYearTital2016_18 = 2018;
        } else {
            fromMonthTital2016_18 = employeeSheetList.get(0).getFromMonth();
            fromYearTital2016_18 = employeeSheetList.get(0).getFromYear();
            toMonthTital2016_18 = employeeSheetList.get(employeeSheetList.size() - 1).getToMonth();
            toYearTital2016_18 = employeeSheetList.get(employeeSheetList.size() - 1).getToYear();
        }

        try {
            ExcelSheetCreator.statementDuration = "Statement showing the Pay /D.A/& Other Differences w.e.from Dated  " + ExcelSheetCreator.monthList[fromMonthTital2016_18 - 1] + "-" + fromYearTital2016_18 + " to " + ExcelSheetCreator.monthList[toMonthTital2016_18 - 1] + "-" + toYearTital2016_18;
        } catch (Exception e) {
        }

        try {
            ExcelSheetCreator.statementDuration2019 = "Statement showing the Pay /D.A/& Other Differences w.e.from Dated  " + ExcelSheetCreator.monthList[fromMonthTital2019 - 1] + "-" + fromYearTital2019 + " to " + ExcelSheetCreator.monthList[toMonthTital2019 - 1] + "-" + toYearTital2019;
        } catch (Exception e) {
        }


    }

    private static int roundOff(int basicAtthisTime, int lastGradPay) {

        int temp1=0;
        double original=(basicAtthisTime + lastGradPay) * 3 / 100.0;
        temp1=(int)original;
        if(temp1%10==0){
            return temp1;
        }else{
            return (int) (Math.round(original));
        }

    }
    public static int doLookupAndGetTheAdmiissibleBasicPay(int lastAdmissibleBasic, String payBand, int incrementTime) {

        int incrementedBasic = 0;

        if (incrementTime > 0) {
            //incrementedBasic = lastAdmissibleBasic + Util.roundOffIncrement((int) (Math.round((lastAdmissibleBasic) * 3 / 100.0) * incrementTime));
            incrementedBasic = lastAdmissibleBasic + Util.roundOffIncrement(roundOff(lastAdmissibleBasic,0) * incrementTime);
            int reminderUpTo100Place = incrementedBasic % 100;
            if (reminderUpTo100Place > 50) {
                incrementedBasic = incrementedBasic + (100 - reminderUpTo100Place);
            } else {
                incrementedBasic = incrementedBasic - reminderUpTo100Place;
            }

        } else {
            incrementedBasic = lastAdmissibleBasic;
        }
        int new7PaySalary = 0;
        int[] i = PayBandMapObject.payBandLevelArrayMaping.get(payBand);
        if (i == null) {
            i = PayBandMapObject.payBandLevelArrayMaping.get(67000);
        }
        for (int data : i) {
            if (incrementedBasic == data || incrementedBasic < data) {
                new7PaySalary = data;
                break;
            }
        }
        return new7PaySalary;
    }
}
