package CashRegister;


import java.util.HashMap;

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

    private HashMap<String, Integer> getAvailableBillsMap(){
        HashMap<String, Integer> availableBillsMap = new HashMap<String, Integer>();
        availableBillsMap.put("twenties", this.twenties);
        availableBillsMap.put("tens", this.tens);
        availableBillsMap.put("fives", this.fives);
        availableBillsMap.put("twos", this.twos);
        availableBillsMap.put("ones", this.ones);
        return availableBillsMap;
    }

    public String change(int num) {
        this.calculateAmount();
       int [] changeBills = {0, 0, 0, 0, 0};
        HashMap<String, Integer> availableBillsMap = getAvailableBillsMap();

        if (num>total){
           return ("sorry, insufficient amount in register");
       }
       while(num>0){
           if (num >= 20 && this.twenties>0){
               num -= 20;
               changeBills[0]+=1;
               this.twenties -=1;
           }
           else if (num>=10 && this.tens>0){
               num -= 10;
               changeBills[1]+=1;
               this.tens -=1;
           }

           else if (num>=5&& this.fives>0){
               num -= 5;
               changeBills[2]+=1;
               this.fives -=1;
           }

           else if (num>=2 && this.twos>0){
               num -= 2;
               changeBills[3]+=1;
               this.twos -=1;
           }

           else if (num>=1 && this.ones>0){
               num -= 1;
               changeBills[4]+=1;
               this.ones -=1;
           }
       }

        return  (changeBills[0] + " "+ changeBills[1] + " " + changeBills[2] + " " + changeBills[3] + " "+ changeBills[4]);
    }

    public String toString(){
        return "$" + this.total + " " + this.twenties + " " + this.tens + " " + this.fives +  " " + this.twos + " " + this.ones;
    }


}
