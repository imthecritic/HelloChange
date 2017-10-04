package CashRegister;

/**
 * This is an interface for currency, defining the basic methods needed in all currency classes
 */
public interface Money {

    /**
     * Calculates the monetary amount of the money given
     */
    void calculateAmount();

    /**
     * Returns the monetary amount of the money given
     * * @return int
     */
    int getAmount();

    /**
     * Gets a list of the bills available
     * @return int[]
     */
    int[] getBills();

    /**
     * Adds bills to the current set of bills
     * @param bills
     */
    void putBills(int[] bills);

    /**
     * Removes bills from the current set of bills
     * @param bills
     */
    void takeBills(int[] bills);

    /**
     * Changes a monetary value and removes bills from set of bills, if possible
     * @param num
     */
    void change (int num);

    /**
     * Returns a readable version of the amount and the bills
     * @return
     */
    String toString();
}
