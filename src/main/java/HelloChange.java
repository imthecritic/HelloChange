import java.util.Scanner;

/**
 *
 */
public class HelloChange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ready");

        while (true){
            String input = scanner.nextLine();
            String[] inputArray = input.split("\\s+");

            if (inputArray[0].equals("show")){
                // return total in register
                System.out.println("Total");
            }

            if (inputArray[0].equals("put")){
                if(inputArray.length != 6){
                    System.out.println("invalid input, try again");
                }
                else {
                    System.out.println("put");
                }
            }

            if (inputArray[0].equals("take")){
                if(inputArray.length != 6){
                    System.out.println("invalid input, try again");
                }
                else {
                    System.out.println("take");
                }
            }

            if (inputArray[0].equals("change")){
                if(inputArray.length != 2){
                    System.out.println("invalid input, try again");
                }
                else {
                    System.out.println("change");
                }
            }

            if (inputArray[0].equals("quit")){
                System.out.println("Bye");
                break;
            }

        }


    }

}
