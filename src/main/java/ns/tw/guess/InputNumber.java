package ns.tw.guess;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Created by lixueying on 15/11/22.
 */
public class InputNumber {

    String guessed = "";
    String generated = "";
    String tip = "";
    int count = 6;
    NumberGenerator generator = new NumberGenerator(new Random());
    CompareNumber compareNumber = new CompareNumber();

    public void input(){
        generated = generator.generate();
        System.out.println(generated);
        System.out.println("Welcome!");
        System.out.print("Please input your number(﴾6)﴿:");

        loop:
        for(count=5;count>=0;--count){
            Scanner scanner = new Scanner(System.in);
            guessed = scanner.next();

            try{
                parseInt(guessed);
            }catch (NumberFormatException e) {
                System.out.println("Not number");
                break loop;
            }

            for (int index = 0; index < guessed.length(); index++) {
                if (guessed.indexOf(guessed.charAt(index)) != guessed.lastIndexOf(guessed.charAt(index))) {
                    System.out.println("Cannot input duplicate numbers!");
                    break loop;
                }
            }
            tip = compareNumber.compare(generated,guessed);
            if(tip.equals("4A0B")){
                System.out.println("Congratulations!");
                break loop;
            }else{
                System.out.println(tip);
                if(count != 0){
                    System.out.print("Please input your number(﴾"+count+")﴿:");
                }else{
                    System.out.println("Game Over");
                }
            }
        }
    }
}
