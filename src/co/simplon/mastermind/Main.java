package co.simplon.mastermind;

import java.util.ArrayList;
import java.util.Scanner;

import static co.simplon.mastermind.handleNumber.DecomposeNumber.decompose;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to mastermind puzzle.");
        System.out.println("Choose the difficulty level you want:");
        System.out.println("1. Very easy");
        System.out.println("2. Easy");
        System.out.println("3.Normal");
        System.out.println("4.Hard");
        System.out.println("5.Hardcode");

        int level = scanner.nextInt();
        int numberdigits = 0;
        switch (level){
            case 1:
                numberdigits = 2;
                break;
            case 2:
                numberdigits = 3;
                break;
            case 3:
                numberdigits = 4;
                break;
            case 4:
                numberdigits = 8;
                break;
            case 5:
                numberdigits = 16;
                break;
        }

        long limit = (long) Math.pow(10, numberdigits-1);
        System.out.println("Try to guess a number between 0 and "+ limit
         +", you have max 5 attempts ");

        try (Scanner in = new Scanner(System.in)){
            int time = 0;
            long randomNumber = (long) (Math.random()*limit);
            boolean shouldContinue = true;

            while (shouldContinue && time < 5){
                String input = in.nextLine();
                try{
                    long inputNumber = Long.parseLong(input);
                    if (inputNumber>0 && inputNumber<limit){
                        if (randomNumber == inputNumber){
                            shouldContinue = false;
                            System.out.println("Great! You win!");
                        }else {
                            time++;
                            System.out.println("your number is wrong!try again...");

                            ArrayList<Integer> inputNumberArr = decompose(inputNumber);
                            ArrayList<Integer> randomNumberArr = decompose(randomNumber);
                            StringBuilder tip = getStringBuilder(inputNumberArr, randomNumberArr);
                            System.out.println(tip);
                        }
                    }else {
                        System.out.println("Please, entre a number entre 0000 and "+ limit);
                        time++;
                    }

                }catch (NumberFormatException e){
                    System.out.println("Please, entre a number");
                    time++;
                }
            }
        }
        }

    private static StringBuilder getStringBuilder(ArrayList<Integer> inputNumberArr, ArrayList<Integer> randomNumberArr) {
        StringBuilder tip = new StringBuilder();

        for (int i = 0; i < inputNumberArr.size(); i++) {
            if (inputNumberArr.get(i) == randomNumberArr.get(i)){
                tip.append(inputNumberArr.get(i));
            }else if(inputNumberArr.get(i) > randomNumberArr.get(i)){
                tip.append("-");
            }else {
                tip.append("+");
            }
        }
        return tip;
    }

}


