import java.util.Random;




public class Hand {
    public int MAX_CARDS = 35;
    private Card[] myCards;
    private int numCards;

    public Hand() {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    public void resetHand() {
        myCards = new Card[MAX_CARDS];
        numCards = 0;
    }

    public boolean takeCard(Card card) {
        if (numCards == MAX_CARDS) {
            return false;
        }
        if (card.getErrorFlag()) {
            return true;
        }
        myCards[numCards++] = new Card(card.getValue(), card.getSuit());
        return true;
    }

    Card playCard() {
        if(numCards == 0) {
            return null;
        }
        return myCards[--numCards];
    }

    public String toString() {
        String output = "";
        for(int i=0; i<numCards; i++) {
            output += myCards[i] + ",\t";
        }
        return output;
    }

    public int getNumCards() {
        return numCards;
    }
    public Card inspectCard(int k) {
        if(k < 0 || k >= numCards) {
            return new Card('X', Card.Suit.SPADES);
        } else {
            return myCards[k];
        }
    }
}
    
