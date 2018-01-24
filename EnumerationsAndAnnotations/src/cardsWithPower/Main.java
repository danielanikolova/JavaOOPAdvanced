package cardsWithPower;

import javax.smartcardio.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        RankPower currentRank = RankPower.valueOf(br.readLine().toUpperCase());
        SuitPower currentSuit = SuitPower.valueOf(br.readLine().toUpperCase());

        Card card = new Card(currentSuit,currentRank);

        System.out.println(card.toString());
    }
}
