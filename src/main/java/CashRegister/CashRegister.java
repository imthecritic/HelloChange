package CashRegister;

/**
 * Created by jasminefarley on 10/3/17.
 */
public class CashRegister {

    private USMoney usMoney;

    public CashRegister(){}

    public CashRegister(int twenties, int tens, int fives, int twos, int ones){
        usMoney = new USMoney(twenties, tens, fives, twos, ones);
    }

    public void put(String[] array){

    }

    public void change(String numString){

    }

    public String show() {
        return  usMoney.toString();
    }

    public String toString(){
        return usMoney.toString();
    }
}
