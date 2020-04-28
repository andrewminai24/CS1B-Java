/*
A.Inital Comment: Author: Andrew Minai
This program shows the card deck and  of 52 cards
and this is my main class in which I am running my functions and instances of objects.
*/
import java.util.Random;

public class Foothill{
    public static void main(String args[]) {
 /*This is where I created 4 types of cards and
  create a instance of the object Card
  */ 
        Card cards[] = new Card[4];
        cards[0] = new Card('A', Card.Suit.SPADES);
        cards[1] = new Card('T', Card.Suit.HEARTS);
        cards[2] = new Card('7', Card.Suit.CLUBS);
        cards[3] = new Card('4', Card.Suit.DIAMONDS);

        Hand h = new Hand();
        Random r = new Random();

        while(true) {
            boolean status = h.takeCard(cards[r.nextInt(4)]);

            if(!status) {
                break;
            }
        }

        System.out.println(h);

        while(h.getNumCards() != 0) {
            System.out.println(h.playCard());
        }

        System.out.println("Now empty hand");
    }
}
