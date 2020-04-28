import java.util.Arrays;
import java.util.List;

public class Card {

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;

        @Override
        public String toString() {
            return name().substring(0, 1);
        }
    }

    private Suit suit;
    private char value;
    boolean errorFlag;
    private static List<Character> ranks = Arrays.asList('2','3','4','5','6','7','8','9','T','J','Q','K','A'); 

    static boolean isValid(char value, Suit suit) {
        return ranks.indexOf(value) != -1;
    }

    public Card(String s, int i) {

    }

    public Card(char r, Suit s) {
        suit = s;
        if(ranks.indexOf(r) != -1) {
            value = r;
        } else {
            value = 'A';
            errorFlag = true;
        }       
    }
    public Card() {
        suit = Suit.SPADES;
        value = 'A';
    }

    public Suit getSuit() {
        return suit;
    }

    public char getValue() {
        return value;
    }

    public boolean getErrorFlag() {
        return errorFlag;
    }

    public boolean set(char r, Suit s) {
        suit = s;
        if(ranks.indexOf(r) != -1) {
            value = r;
            errorFlag = false;
        } else {
            value = 'A';
            errorFlag = true;
        }
        return errorFlag;
    }

    @Override
    public String toString() {
        if(errorFlag) {
            return "******* Illegal *********";
        }
        return value + " of " +suit.toString();
    }

    public boolean equals(Card other) {
        if (suit != other.suit)
            return false;
        if (value != other.value)
            return false;
        return true;
    }

}



