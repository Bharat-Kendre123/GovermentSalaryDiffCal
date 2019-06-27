package employee.styling;

import employee.models.SalaryCalculatonDuraton;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 4/14/19
 * Time: 5:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class UtilForJanIncrement {


    public static void main(String[] x) {
        List<SalaryCalculatonDuraton> list = getListOnBasisOfJanIncrementYeary(15, 1, 2015, 15, 1, 2016, 13, 2, 2019);
        System.out.println("HI BHARAT");
    }

    public static List<SalaryCalculatonDuraton> getListOnBasisOfJanIncrementYeary(int jDay, int jMonth, int jYear, int fromDay, int fromMonth, int fromYear, int toDay, int toMonth, int toYear) {
        int tempFromDay = fromDay;
        int tempToYear = toYear;
        int tempFromMonth = fromMonth;
        int tempToMonth = toMonth;
        List<SalaryCalculatonDuraton> salaryCalculatonDuratons = new ArrayList<>();

        /* FFIRST STEP OF CALCULATING JAN INCREMENT EMPLOYEE LLIST IS TOO SPLIT THE INPUT EEMPLYEE
            DETAIL INTO YEAR LIST
            */
        for (int year = fromYear; year <= toYear; year++) {
            if (year == toYear)  // LAST STEP OR FIRST ITERATION
            {
                salaryCalculatonDuratons.add(new SalaryCalculatonDuraton(tempFromDay, tempFromMonth, year, toDay, tempToMonth, tempToYear));
            } else {           // FIRST OR MID ITERATONS
                YearMonth lengthOfMonth = YearMonth.of(year, 12);  //calculated lenght of month in days
                salaryCalculatonDuratons.add(new SalaryCalculatonDuraton(tempFromDay, tempFromMonth, year, lengthOfMonth.lengthOfMonth(), 12, year));
                tempFromMonth = 1;
                tempFromDay = 1;
            }

        }

        return decideExactIncrementlock(jDay, jMonth, jYear, salaryCalculatonDuratons);
    }

    public static List<SalaryCalculatonDuraton> decideExactIncrementlock(int jDay, int jMonth, int jYear, List<SalaryCalculatonDuraton> salaryCalculatonDuratons) {
        List<SalaryCalculatonDuraton> salaryCalculatonDuratons1 = new ArrayList<>();

        int coounter = 0;
        for (SalaryCalculatonDuraton salaryCalculatonDuraton : salaryCalculatonDuratons) {
            if (coounter == 0) {
                salaryCalculatonDuraton.setIncrement(false);
            } else {
                int tempForMonth = jMonth + 5;
                if (tempForMonth < 12 && jYear < salaryCalculatonDuraton.getFromYear()) {
                    salaryCalculatonDuraton.setIncrement(true);
                } else if (tempForMonth == 12 && jYear < salaryCalculatonDuraton.getFromYear()) {
                    if (jDay == 1) {
                        salaryCalculatonDuraton.setIncrement(true);
                    } else {
                        if (jYear + 1 < salaryCalculatonDuraton.getFromYear()) {
                            salaryCalculatonDuraton.setIncrement(true);
                        } else {
                            salaryCalculatonDuraton.setIncrement(false);
                        }
                    }
                } else {
                    if (jYear + 1 < salaryCalculatonDuraton.getFromYear()) {
                        salaryCalculatonDuraton.setIncrement(true);
                    } else {
                        salaryCalculatonDuraton.setIncrement(false);
                    }
                }
            }
            coounter++;
            salaryCalculatonDuratons1.add(salaryCalculatonDuraton);
        }
        return salaryCalculatonDuratons1;
    }
}
