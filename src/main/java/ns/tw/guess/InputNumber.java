package ns.tw.guess;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Created by lixueying on 15/11/22.
 */
public class InputNumber {

    static String guessed = "";
    static String generated = "";
    static String tip = "";

    private static int COUNT = 6;

    static NumberGenerator generator = new NumberGenerator(new Random());
    static CompareNumber compareNumber = new CompareNumber();

    public static void main(String[] args){
        generated = generator.generate();
        System.out.println(generated);
        System.out.println("Welcome!");
        System.out.print("Please input your number(﴾6)﴿:");

        for(COUNT=5;COUNT>=0;--COUNT){
            Scanner scanner = new Scanner(System.in);
            guessed = scanner.next();

            if(is_duplicate_numbers(guessed)){
                tip = compareNumber.compare(generated,guessed);
                getResult(tip);
            }else{
                break;
            }
        }
    }

    public static boolean is_duplicate_numbers(String guessed){
        try{
            parseInt(guessed);
        }catch (NumberFormatException e) {
            System.out.println("Not number");
            return false;
        }

        for (int index = 0; index < guessed.length(); index++) {
            if (guessed.indexOf(guessed.charAt(index)) != guessed.lastIndexOf(guessed.charAt(index))) {
                System.out.println("Cannot input duplicate numbers!");
                return false;
            }
        }
        return true;
    }

    public static void getResult(String tip){
        if(tip.equals("4A0B")){
            System.out.println("Congratulations!");
        }else{
            System.out.println(tip);
            if(COUNT != 0){
                System.out.print("Please input your number(﴾"+COUNT+")﴿:");
            }else{
                System.out.println("Game Over");
            }
        }
    }
}
