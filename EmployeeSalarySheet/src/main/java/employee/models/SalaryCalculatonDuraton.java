package employee.models;

import java.time.YearMonth;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 4/1/19
 * Time: 4:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class SalaryCalculatonDuraton {

    public int fromDay;
    public int fromMonth;
    public int fromYear;
    public int toDay;
    public int toMonth;
    public int toYear;
    public boolean isIncrement;
    public boolean isStartMonthNotCompelete;   // default is false
    public boolean isEndMonthNotCompelete;   // default is false
    public boolean inComplete;   // default is false


    public SalaryCalculatonDuraton(int fromDay, int fromMonth, int fromYear, int toDay, int toMonth, int toYear) {
        this.fromDay = fromDay;
        this.fromMonth = fromMonth;
        this.fromYear = fromYear;
        this.toDay = toDay;
        this.toMonth = toMonth;
        this.toYear = toYear;

        /*for from month we can dirrectly check the date is mid day of month orr not
         *  because start date is always 1 but eend day may be diffferent. So we arre calulating date
         *  and check it
         * */
        YearMonth lengthOfMonth = YearMonth.of(toYear, toMonth);
        if (fromDay != 1 || lengthOfMonth.lengthOfMonth() != toDay) {
            inComplete = true;
            if (fromDay != 1 && lengthOfMonth.lengthOfMonth() != toDay) {
                isStartMonthNotCompelete = true;
                isEndMonthNotCompelete = true;
            } else if (fromDay != 1) {
                isStartMonthNotCompelete = true;
            } else {
                isEndMonthNotCompelete = true;
            }
        }

    }

    public int getFromDay() {
        return fromDay;
    }

    public void setFromDay(int fromDay) {
        this.fromDay = fromDay;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(int fromMonth) {
        this.fromMonth = fromMonth;
    }

    public int getFromYear() {
        return fromYear;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public int getToDay() {
        return toDay;
    }

    public void setToDay(int toDay) {
        this.toDay = toDay;
    }

    public int getToMonth() {
        return toMonth;
    }

    public void setToMonth(int toMonth) {
        this.toMonth = toMonth;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    public boolean isIncrement() {
        return isIncrement;
    }

    public void setIncrement(boolean increment) {
        isIncrement = increment;
    }

    public boolean isStartMonthNotCompelete() {
        return isStartMonthNotCompelete;
    }

    public void setStartMonthNotCompelete(boolean startMonthNotCompelete) {
        isStartMonthNotCompelete = startMonthNotCompelete;
    }

    public boolean isEndMonthNotCompelete() {
        return isEndMonthNotCompelete;
    }

    public void setEndMonthNotCompelete(boolean endMonthNotCompelete) {
        isEndMonthNotCompelete = endMonthNotCompelete;
    }

    public boolean isInComplete() {
        return inComplete;
    }

    public void setInComplete(boolean inComplete) {
        this.inComplete = inComplete;
    }
}
