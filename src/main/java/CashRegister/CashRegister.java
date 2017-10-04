package CashRegister;

/**
 * This is a class that represents the commands a USMoney register can take
 */
public class CashRegister {

    private Money money;

    public CashRegister(USMoney usMoney){
        this.money = usMoney; //Default is US Money
    }

    public CashRegister(int twenties, int tens, int fives, int twos, int ones){
        money = new USMoney(twenties, tens, fives, twos, ones);
    }

    public void put(String[] array){
        int[] bills = new int[array.length];
        for (int i = 0; i< array.length; i++){
            bills[i] = Integer.parseInt(array[i]);
        }
        money.putBills(bills);
    }

    public void take(String[] array){
        int[] bills = new int[array.length];
        for (int i = 0; i< array.length; i++){
            bills[i] = Integer.parseInt(array[i]);
        }
        money.takeBills(bills);
    }

    public void change(String numString){ money.change(Integer.parseInt(numString)); }

    public String show() {
        return  money.toString();
    }

    public String toString(){
        return money.toString();
    }
}
