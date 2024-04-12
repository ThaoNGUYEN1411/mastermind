package co.simplon.mastermind.guessnumber;

import java.util.ArrayList;
import java.util.Scanner;

import static co.simplon.mastermind.handleNumber.DecomposeNumber.decompose;
import static co.simplon.mastermind.handleNumber.RepeatString.repeatString;

public class InputNumber {
    public static void main(String[] args) {
        System.out.println("Welcome to mastermind puzzle.");
        System.out.println("Enter a number( contains from 2 to 16 digits)");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        ArrayList<Integer> inputNumber = decompose(Long.parseLong(input));

        int digitsEnter = input.length();
        String firstNumber = repeatString("5", digitsEnter);

        System.out.println(firstNumber);
        ArrayList<Integer> compGuess = decompose(Integer.parseInt(
                firstNumber));

        int time = 0;
        while (time<3){
            StringBuilder str = new StringBuilder();
            StringBuilder tip = new StringBuilder();
            int n = time==2 ? 1 : 2;
            time++;

            for (int i = 0; i < inputNumber.size(); i++) {
                if (inputNumber.get(i).equals(compGuess.get(i))){
                    tip.append(inputNumber.get(i));
                    compGuess.set(i, compGuess.get(i));
                    str.append(compGuess.get(i));
                }else if(inputNumber.get(i) < compGuess.get(i)){
                    compGuess.set(i, compGuess.get(i)-n);
                    tip.append("-");
                    str.append(compGuess.get(i));
                }else {
                    compGuess.set(i, compGuess.get(i)+n);
                    tip.append("+");
                    str.append(compGuess.get(i));
                }
            }
            System.out.println(tip);
            System.out.println(str);
        }

    }
}
