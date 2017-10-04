import CashRegister.CashRegister;
import CashRegister.USMoney;

import java.util.Scanner;

/**
 *
 * This is the command line version of the cash register
 *
 */
public class HelloChange {

    static USMoney usMoney = new USMoney(1, 2, 3, 4 , 5);

    static CashRegister cashRegister = new CashRegister(usMoney);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ready");

        while (true){
            String input = scanner.nextLine();
            String[] inputArray = input.split("\\s+");

            if (inputArray[0].equals("show")){
                System.out.println(cashRegister.show());
            }

            if (inputArray[0].equals("put")){
                if(inputArray.length != 6){
                    System.out.println("invalid input, try again");
                }
                else {
                    String[] numStrings = {inputArray[1], inputArray[2],  inputArray[3],  inputArray[4],  inputArray[5]};
                    cashRegister.put(numStrings);
                    System.out.println(cashRegister.show());
                }
            }

            if (inputArray[0].equals("take")){
                if(inputArray.length != 6){
                    System.out.println("invalid input, try again");
                }
                else {
                    String[] numStrings = {inputArray[1], inputArray[2],  inputArray[3],  inputArray[4],  inputArray[5]};
                    cashRegister.take(numStrings);
                    System.out.println(cashRegister.show());
                }
            }

            if (inputArray[0].equals("change")){
                if(inputArray.length != 2){
                    System.out.println("invalid input, try again");
                }
                else {
                    cashRegister.change(inputArray[1]);
                }
            }

            if (inputArray[0].equals("quit")){
                System.out.println("Bye");
                break;
            }

        }

    }

}
