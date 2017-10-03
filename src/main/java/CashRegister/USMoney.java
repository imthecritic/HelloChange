package CashRegister;


public class USMoney implements  Money {

    private  int twenties;
    private  int tens;
    private int fives;
    private int twos;
    private int ones;
    private int total;

    public USMoney(){
    }

    public USMoney(int twenties, int tens, int fives, int twos, int ones){
        this.twenties = twenties;
        this.tens = tens;
        this.fives = fives;
        this.twos = twos;
        this.ones = ones;
    }

    public void calculateAmount() {
        total += (this.twenties*20) + (this.tens*10) + (this.fives*5) + (this.twos*2) + this.ones;
    }

    public int getAmount() {
        calculateAmount();
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
    }

    public void takeBills(int[] bills) {
        this.twenties -= bills[0];
        this.tens -= bills [1];
        this.fives -= bills[2];
        this.twos -= bills[3];
        this.ones -= bills[4];

    }

    public int[] change(int num) {
        return new int[0];
    }


}
