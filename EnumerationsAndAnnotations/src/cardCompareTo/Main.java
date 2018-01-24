package cardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Card> cards = new LinkedList<>();

        for (int i = 0; i < 2; i++) {
            RankPower currentRank = RankPower.valueOf(br.readLine().toUpperCase());
            SuitPower currentSuit = SuitPower.valueOf(br.readLine().toUpperCase());

            Card card = new Card(currentSuit,currentRank);
            cards.add(card);
        }


        if (cards.get(0).compareTo(cards.get(1))>0){
            System.out.println(cards.get(0).toString());
        }else System.out.println(cards.get(1).toString());

    }
}
