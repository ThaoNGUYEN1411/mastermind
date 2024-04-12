package co.simplon.mastermind.handleNumber;

import java.util.ArrayList;

public class DecomposeNumber {
    public static ArrayList<Integer> decompose(long n){
        String numberAsString = String.valueOf(n);
        ArrayList<Integer> digitsList= new ArrayList<>();

        for (int i = 0; i < numberAsString.length(); i++) {
            int digit = Character.getNumericValue(numberAsString.charAt(i));
            digitsList.add(digit);
        }

        return digitsList;
    }
}
