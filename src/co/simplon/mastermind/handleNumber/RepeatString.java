package co.simplon.mastermind.handleNumber;

public class RepeatString {
    String s= "";
    public static String repeatString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    String firstGuess = repeatString("5", 3)
}
