import java.util.Scanner;
import java.io.File;


public class Runner {
   public static void main(String[] args) {
          
              { // Phase 1
          
              Card firstCard; Card secondCard; Card thirdCard;
          
              firstCard = new Card('A', Card.Suit.spades);
              secondCard = new Card('X', Card.Suit.spades);
              thirdCard = new Card('3', Card.Suit.clubs);
          
              System.out.println(firstCard.toString());
              System.out.println(secondCard.toString());
              System.out.println(thirdCard.toString());
          
              firstCard.set('O', Card.Suit.spades);
              secondCard.set('Q', Card.Suit.spades);
          
              System.out.println(firstCard.toString());
              System.out.println(secondCard.toString());
              System.out.println(thirdCard.toString());
          
              if (firstCard.equals(firstCard))
                  System.out.println("Equal");
              else
                  System.out.println("Not Equal");
          
              }
          
              System.out.println("Phase 2"); { // Phase 2
          
              Card handcard1 = new Card('3', Card.Suit.clubs);
              Card handcard2 = new Card('T',Card.Suit.clubs);
              Card handcard3 = new Card('9',Card.Suit.hearts);
          
              Hand myHand = new Hand();
          
              int i = 0;
              while (i < 1000)
              {
                  if (myHand.takeCard(handcard1))
                  {
                      if(myHand.takeCard(handcard2))
                      {
                          if (myHand.takeCard(handcard3)) { // Needs to be improve ?
                              }
                          else
                              break;
                          }
                      else
                      {
                          break;
                      }
                  }
                  else
                      break;
                }
          
              System.out.println("Hand full");
              System.out.println("After deal");
              System.out.println("Hand =" + myHand.toString()); // Next, play each card in a loop, until the hand is empty.
                                                                // Display the card played as it is played, and finally, display the
                                                               // (now empty) hand,
                                                               // verifying that no cards remain. At some point in your program,
                                                               // test inspectCard()
                                                               // with both legal and illegal int arguments
          
              System.out.println("Testing inspectCard()");
              System.out.println(myHand.inspectCard(5).toString());
              System.out.println(myHand.inspectCard(500).toString());
              while (myHand.getNumCards() != 0) {
          
              System.out.println("Playing " + myHand.playCard().toString());
           }
       }

       // System.out.print("Phase 3");
       {
           // Create deck of Two Packs
           Deck deck = new Deck(2);
          
              while (deck.getTopCard() != 0)
                  System.out.print(deck.dealCard().toString()+ " / ");
          
          
          
              deck.init(2);
              deck.shuffle();
          
              while (deck.getTopCard() != 0)
                  System.out.print(deck.dealCard().toString()+ " / ");
          
              System.out.println("\n"); // Create deck of Single Pack
          
              deck.init(1);
          
              while (deck.getTopCard() != 0)
                  System.out.print(deck.dealCard().toString()+ " / ");
          
              deck.init(1);
              deck.shuffle();
              while (deck.getTopCard() != 0)
                   System.out.print(deck.dealCard().toString()+ " / ");
          
              System.out.println("\nPress any key to continue . . .");
          
       }

       // System.out.print("Phase 4");
       {
           Hand hand[] = new Hand[10];
           Scanner keyboard = new Scanner(System.in);
           int numberOfPlayers = 0;
           while (numberOfPlayers < 1 || numberOfPlayers > 10) {
               System.out.println("How many hands? (1 - 10, please):");
               numberOfPlayers = keyboard.nextInt();
           } // Instantiate a single-pack Deck
           Deck deck = new Deck(1);

           for (int j = 0; j < numberOfPlayers; j++)
               hand[j] = new Hand();

           for (int i = 0; i < (52 / numberOfPlayers); i++) {
               for (int j = 0; j < numberOfPlayers; j++) {
                   hand[j].takeCard(deck.dealCard());
               }
           }

           System.out.println("Here are our hands, from unshuffled deck:");
           for (int j = 0; j < numberOfPlayers; j++) {
               System.out.print("Hand = ( ");
              
               for (int i = 0; i < (52 / numberOfPlayers); i++) {
                   System.out.print(hand[j].playCard().toString());
                   if (i != (52 / numberOfPlayers) - 1)
                       System.out.print(",");
                   else
                       System.out.println(")");
               }
           }

           // System.out.println("Printed all players card");
           deck.init(1);

           deck.shuffle();

           for (int j = 0; j < numberOfPlayers; j++)
               hand[j] = new Hand();

           for (int i = 0; i < (52 / numberOfPlayers); i++) {
               for (int j = 0; j < numberOfPlayers; j++) {
                   hand[j].takeCard(deck.dealCard());
               }
           }

           System.out.println("Here are our hands, from SHUFFLED deck:");
           for (int j = 0; j < numberOfPlayers; j++) {
               System.out.print("Hand = ( ");
               for (int i = 0; i < (52 / numberOfPlayers); i++) {
                   System.out.print(hand[j].playCard().toString());
                   if (i != (52 / numberOfPlayers) - 1)
                       System.out.print(",");
                   else
                       System.out.println(")");
               }
           }

       }
   }
}