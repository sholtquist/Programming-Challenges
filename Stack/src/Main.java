import java.io.*;
import java.util.*;

public class Main {

    public static class Card {

        String value;
        String suit;

        public Card(String v, String s) {

            value = v;
            suit = s;

        }

        public String toString() {
            return value + " of " + suit;
        }

    }

    public static class Deck {

        Card[] cards = new Card[52];
        final String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        public Deck(){
            int current = 0;
            for (int i=0; i < 4; i++){
                for (int j=0; j < 13; j++){
                    cards[current] = new Card(values[j], suits[i]);
                    current++;
                }
            }
        }//build a deck

        public Card[] get(){
            return this.cards;
        }

        public void set(Card[] newCards){
            cards = newCards;
        }

        public Deck shuffle(int shuffleOrder, int[][] shuffles){

            Deck tempDeck = new Deck();
            Card[] newCards = new Card[52];
            for (int i=0; i < 52; i++){
                int tmp = shuffles[shuffleOrder-1][i];
                newCards[i] = this.get()[tmp-1];
            }
            tempDeck.set(newCards);
            return tempDeck;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (int i=0; i < 52; i++){
                sb.append(cards[i].toString());
                if (i < 51) sb.append("\n");
            }
            return sb.toString();
        }

    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(reader.readLine());
        //reader.readLine();
        //System.out.println(cases + " cases");
        for(int i = 0; i < cases; i++) {

            Deck deck = new Deck();
            if(i == 0) {reader.readLine();}

            int numShuffles = Integer.parseInt(reader.readLine());
            //System.out.println(numShuffles + " shuffles");
            //int totalLength = 52 * numShuffles;
            int[][] shuffles = new int[numShuffles][52];

            int offset = 0;
            int[] ints = new int[52 * numShuffles];
            while (true){
                String[] stringLine = reader.readLine().split(" ");
                for (int j=0; j < stringLine.length; j++){
                    ints[offset+j] = Integer.parseInt(stringLine[j]);
                }
                offset += stringLine.length;
                //System.out.println(offset + " : " + ints.length);
                if (offset == ints.length) {break;}
            }
            //System.out.println("OUT");
            offset = 0;

            for (int z=0;z<numShuffles;z++){
                shuffles[z] = Arrays.copyOfRange(ints,offset,offset+52);
                offset += 52;
            }

            String line;
            int shuffleOrder;
            while ((line = reader.readLine())!= null && !line.equals(" ") && !line.equals("") && !line.equals("\n")){
                //System.out.println("stuck");
                shuffleOrder = Integer.parseInt(line);
                deck = deck.shuffle(shuffleOrder, shuffles);
            }

            //System.out.println("END TEST");
            System.out.println(deck.toString());
            if (i < cases-1) {System.out.println();}

        }

    }

}