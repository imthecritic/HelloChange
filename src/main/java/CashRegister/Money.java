package CashRegister;

/**
 * Created by jasminefarley on 10/3/17.
 */
public interface Money {

    public void calculateAmount();
    public int getAmount();
    public int[] getBills();
    public void putBills(int[] bills);
    public void takeBills(int[] bills);
    public String toString();
}
