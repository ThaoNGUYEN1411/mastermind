package co.simplon.mastermind.guessnumber;

public class HandleNumber {
    private StringBuilder firstCompuGuess = new StringBuilder();

    public StringBuilder repeatString(String str, int num){
        firstCompuGuess.append(String.valueOf(str).repeat(Math.max(0, num)));
        return  firstCompuGuess;
    }

}
