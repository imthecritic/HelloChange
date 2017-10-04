package CashRegister;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USMoney implements  Money {

    private  int twenties;
    private  int tens;
    private int fives;
    private int twos;
    private int ones;
    private int total;

    public USMoney(){}

    public USMoney(int twenties, int tens, int fives, int twos, int ones){
        this.twenties = twenties;
        this.tens = tens;
        this.fives = fives;
        this.twos = twos;
        this.ones = ones;
        calculateAmount();
    }

    public void calculateAmount() {
        total = ((this.twenties*20) + (this.tens*10) + (this.fives*5) + (this.twos*2) + this.ones);
    }

    public int getAmount() {
        this.calculateAmount();
        return total;
    }

    public int[] getBills() {
        int [] bills = {this.twenties, this.tens, this.fives, this.twos, this.ones};
        return bills;
    }

    public void putBills(int[] bills) {
        this.twenties += bills[0];
        this.tens += bills [1];
        this.fives += bills[2];
        this.twos += bills[3];
        this.ones += bills[4];
        this.calculateAmount();
    }

    public void takeBills(int[] bills) {
        this.twenties -= bills[0];
        this.tens -= bills [1];
        this.fives -= bills[2];
        this.twos -= bills[3];
        this.ones -= bills[4];
        this.calculateAmount();
    }

    private HashMap<Integer, Integer> getAvailableBillsMap(){
        HashMap<Integer, Integer> availableBillsMap = new HashMap<Integer, Integer>();
        availableBillsMap.put(20, this.twenties);
        availableBillsMap.put(10, this.tens);
        availableBillsMap.put(5, this.fives);
        availableBillsMap.put(2, this.twos);
        availableBillsMap.put(1, this.ones);
        return availableBillsMap;
    }

    private int[] getAvailableDenominations(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = getAvailableBillsMap();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>0){
                list.add(entry.getKey());
            }
        }
        int[] toReturn = new int[list.size()];
        for (int i=0; i<toReturn.length; i++){
            toReturn[i] = list.get(i);
        }
        return toReturn;
    }

    public void change(int amount) {
        change(amount, new ArrayList<Integer>(), 0);
    }

    private void change(int num, List<Integer> bills, int pos) {
        calculateAmount();
        HashMap<Integer, Integer> map = getAvailableBillsMap();
        int [] denominations = getAvailableDenominations();
        if(num>total){
            System.out.println("sorry, insufficient amount in register");
        }
        if (num == 0) {
            removeChange(bills);
            System.out.println(printChange(bills));
        } else {
            if (num >= denominations[pos]) {
                bills.add(denominations[pos]);
                change(num - denominations[pos], bills, pos);
                bills.remove(bills.size() - 1);
            }
            if (pos + 1 < denominations.length) {
                change(num, bills, pos + 1);
            }
        }

    }

    private void removeChange(List<Integer> bills) {
        for (Integer bill : bills){
            if (bill.equals(20)){
                this.twenties--;
            }
            if (bill.equals(10)){
                this.tens--;
            }
            if (bill.equals(5)){
                this.fives--;
            }
            if (bill.equals(2)){
                this.twos--;
            }
            if (bill.equals(1)){
                this.ones--;
            }
        }
    }

    private String printChange(List<Integer> bills){
        int [] toReturn = {0, 0, 0, 0, 0};
        for (Integer bill : bills){
            if (bill.equals(20)){
                toReturn[0]++;
            }
            if (bill.equals(10)){
                toReturn[1]++;
            }
            if (bill.equals(5)){
                toReturn[2]++;
            }
            if (bill.equals(2)){
                toReturn[3]++;
            }
            if (bill.equals(1)){
                toReturn[4]++;
            }
        }
        return toReturn[0] +" " + toReturn[1]+" " + toReturn[2]+" " + toReturn[3]+" " + toReturn[4];
    }
    

    public String toString(){
        return "$" + this.total + " " + this.twenties + " " + this.tens + " " + this.fives +  " " + this.twos + " " + this.ones;
    }


}
