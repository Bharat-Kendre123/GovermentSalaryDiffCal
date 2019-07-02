package employee.models;

/**
 * Created with IntelliJ IDEA.
 * User: Bkendre
 * Date: 7/2/19
 * Time: 7:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class GPFDuration {

    private int fMonth;
    private int tMonth;
    private int fYear;
    private int tYear;
    private int amount;


    public GPFDuration(int fMonth, int tMonth, int fYear, int tYear, int amount) {
        this.fMonth = fMonth;
        this.tMonth = tMonth;
        this.fYear = fYear;
        this.tYear = tYear;
        this.amount = amount;
    }

    public int getfMonth() {
        return fMonth;
    }

    public void setfMonth(int fMonth) {
        this.fMonth = fMonth;
    }

    public int gettMonth() {
        return tMonth;
    }

    public void settMonth(int tMonth) {
        this.tMonth = tMonth;
    }

    public int getfYear() {
        return fYear;
    }

    public void setfYear(int fYear) {
        this.fYear = fYear;
    }

    public int gettYear() {
        return tYear;
    }

    public void settYear(int tYear) {
        this.tYear = tYear;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
