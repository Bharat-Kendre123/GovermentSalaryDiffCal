package employee.models;

public class Employee implements Cloneable {

    private SalaryComponenets admissibleSalary;
    private SalaryComponenets drawnSalary;
    private SalaryComponenets diff;
    private int fromDay;
    private int fromMonth;
    private int fromYear;
    private int toDay;
    private int toMonth;
    private int toYear;
    public boolean isStartMonthNotCompelete;   // default is false
    public boolean isEndMonthNotCompelete;   // default is false
    public boolean inComplete;   // default is false
    public boolean monthFlag;

    public Employee() {
        admissibleSalary = new SalaryComponenets();
        drawnSalary = new SalaryComponenets();
        diff = new SalaryComponenets();
    }

    public SalaryComponenets getAdmissibleSalary() {
        return admissibleSalary;
    }

    public void setAdmissibleSalary(SalaryComponenets admissibleSalary) {
        this.admissibleSalary = admissibleSalary;
    }

    public SalaryComponenets getDrawnSalary() {
        return drawnSalary;
    }

    public void setDrawnSalary(SalaryComponenets drawnSalary) {
        this.drawnSalary = drawnSalary;
    }

    public SalaryComponenets getDiff() {
        return diff;
    }

    public void setDiff(SalaryComponenets diff) {
        this.diff = diff;
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

    public boolean isMonthFlag() {
        return monthFlag;
    }

    public void setMonthFlag(boolean monthFlag) {
        this.monthFlag = monthFlag;
    }
}
