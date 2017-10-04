package CashRegister;

/**
 * Created by jasminefarley on 10/3/17.
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
            bills[i] = Integer.getInteger(array[i]);
        }
        money.putBills(bills);
    }

    public void take(String[] array){
        int[] bills = new int[array.length];
        for (int i = 0; i< array.length; i++){
            bills[i] = Integer.getInteger(array[i]);
        }
        money.takeBills(bills);
    }

    public String change(String numString){
        return money.change(Integer.getInteger(numString));
    }

    public String show() {
        return  money.toString();
    }

    public String toString(){
        return money.toString();
    }
}
