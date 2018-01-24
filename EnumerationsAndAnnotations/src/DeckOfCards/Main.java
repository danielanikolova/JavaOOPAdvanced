package DeckOfCards;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        for (Suit suit:Suit.values()) {
            String suitValue = suit.name();
            for (Rank rank:Rank.values()) {
                String rankValue = rank.name();
                System.out.println(rankValue + " of " + suitValue);
            }
        }


    }
}
