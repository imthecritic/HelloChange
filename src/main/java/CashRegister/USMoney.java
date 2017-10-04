package CashRegister;

/**
 * This is a class that represents US Bills available in the register
 */

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

    /**
     * Returns a hashmap of the available bills
     * @return
     */
    private HashMap<Integer, Integer> getAvailableBillsMap(){
        HashMap<Integer, Integer> availableBillsMap = new HashMap<Integer, Integer>();
        availableBillsMap.put(20, this.twenties);
        availableBillsMap.put(10, this.tens);
        availableBillsMap.put(5, this.fives);
        availableBillsMap.put(2, this.twos);
        availableBillsMap.put(1, this.ones);
        return availableBillsMap;
    }

    /**
     * Returns an array of the available denominations
     * @return
     */
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

    /**
     * This is where all of the changing happens, it trys every different combination
     * to get to the number that needs to be changed, and chooses the optimized one that has the bills available
     * Uses a variation of the greedy algorithm similar to the coin change problem
     * @param amount : the value that needs to be changed
     * @param bills : a List of the bills that are added
     * @param pos : the index of where you are in the bills list
     * @return boolean (as of right now), have to get it print sorry when there isn't enough bills
     */
    private boolean change(int amount, List<Integer> bills, int pos) {
        calculateAmount(); //calculates the amount every time to keep the total accurate
        int [] denominations = getAvailableDenominations(); //gets an array of the available type of bills
        if(amount>total){ //if there isn't enough money in the register do this
            System.out.println( "sorry, insufficient amount in register");
            return false;
        }
        if (amount == 0 && billsAvailable(bills)) { //this is the base case for the recursion, once it has reached this point
            removeChange(bills); //remove the bills from the total
            System.out.println(printChange(bills)); //print out the change
            return true;
        }
        else if(amount !=0 && billsAvailable(bills)) { //recursive step
            if (amount >= denominations[pos]) { // if the amount is greater or equal to the current denomination
                bills.add(denominations[pos]); //add the denomination to the bills list
                change(amount - denominations[pos], bills, pos); //called change on the amount minus that denomination
                bills.remove(bills.size() - 1); // removes the last element to avoid calling the same list a again
            }
            if (pos + 1 < denominations.length) { // we go to the next domination value
                change(amount, bills, pos + 1); //call change on the next value to see if there is another combination
            }

        }
        //need another statement for not enough available bills, that doesn't print it a lot of times
        return  false; //returns false if nothing is found that round
    }

    /**
     * takes a List of bills and increments them
     * @param bills
     * @return
     */
    private int[] incrementBills (List<Integer> bills){
        int [] billsArray = {0, 0, 0, 0, 0};
        for (Integer bill : bills){
            if (bill.equals(20)){
                billsArray[0]++;
            }
            if (bill.equals(10)){
                billsArray[1]++;
            }
            if (bill.equals(5)){
                billsArray[2]++;
            }
            if (bill.equals(2)){
                billsArray[3]++;
            }
            if (bill.equals(1)){
                billsArray[4]++;
            }
        }
        return billsArray;

    }

    /**
     * Returns if there are enough bills available for the solution
     * @param bills
     * @return
     */
    private boolean billsAvailable(List<Integer> bills) {
        boolean valid = true;

        int [] billsArray = incrementBills(bills);

        if (billsArray[0]> this.twenties){
            valid = false;
        }
        if (billsArray[1]> this.tens){
            valid = false;
        }
        if (billsArray[2]> this.fives){
            valid = false;
        }
        if (billsArray[3]> this.twos){
            valid = false;
        }
        if (billsArray[4]> this.ones){
            valid = false;
        }
        return valid;
    }


    /**
     * Removes the change from the global bills
     * @param bills
     */
    private void removeChange(List<Integer> bills) {
        for (Integer bill : bills){
            if (bill.equals(20)){
                if (this.twenties>0)
                    this.twenties--;
            }
            if (bill.equals(10)){
                if (this.tens>0)
                    this.tens--;
            }
            if (bill.equals(5)){
                if (this.fives>0)
                    this.fives--;
            }
            if (bill.equals(2)){
                if (this.twos>0)
                    this.twos--;
            }
            if (bill.equals(1)){
                if (this.ones>0)
                    this.ones--;
            }
        }
    }

    /**
     * Formats the change for print
     * @param bills
     * @return
     */
    private String printChange(List<Integer> bills){

        int [] toReturn = incrementBills(bills);
        return toReturn[0] +" " + toReturn[1]+" " + toReturn[2]+" " + toReturn[3]+" " + toReturn[4];
    }

    /**
     * String version of USMoney
     * @return
     */
    public String toString(){
        return "$" + this.total + " " + this.twenties + " " + this.tens + " " + this.fives +  " " + this.twos + " " + this.ones;
    }


}
