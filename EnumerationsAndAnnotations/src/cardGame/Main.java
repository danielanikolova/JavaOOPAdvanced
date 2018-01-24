package cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    private static List<Card> cardDeck = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String player1 = br.readLine();
        String player2 = br.readLine();

        List<Card>cardDeck1 = new ArrayList<>();
        List<Card>cardDeck2 = new ArrayList<>();

        for (Suit suit:Suit.values()) {
            for (Rank rank:Rank.values()) {
                Card card = new Card(suit, rank);
                cardDeck.add(card);
            }
        }


        while (cardDeck1.size()<=4){
            String[] readCard = br.readLine().split("\\s+");
            addCard(cardDeck1, readCard);

        }

        while (cardDeck2.size()<=4){
            String[] readCard = br.readLine().split("\\s+");
            addCard(cardDeck2, readCard);
        }


        List<Card> crads1 = cardDeck1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Card> crads2 = cardDeck2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        Card best1 = crads1.get(0);
        Card best2 = crads2.get(0);

        if (best1.compareTo(best2)>0){
            System.out.printf("%s wins with %s of %s.", player1, best1.getRankPower().name(),
                    best1.getSuitPower().name());
        }else {
            System.out.printf("%s wins with %s of %s.", player2, best2.getRankPower().name(),
                    best2.getSuitPower().name());
        }


    }

    private static void addCard(List<Card> cardDeck1, String[] readCard) {

        try {
            Suit suit = null;
            Rank rank = null;
            try {
                 suit= Suit.valueOf(readCard[2]);
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
                return;
            }
            try {
                rank = Rank.valueOf(readCard[0]);
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            }

            Suit finalSuit = suit;
            Rank finalRank = rank;
            List<Card> cards = cardDeck.stream()
                    .filter(c->c.getSuitPower().name().equalsIgnoreCase(finalSuit.name()))
                    .filter(r->r.getRankPower().name().equalsIgnoreCase(finalRank.name()))
                    .limit(1).collect(Collectors.toList());
            if (cards.size()==0){
                System.out.println("Card is not in the deck.");
            }else {
                Card card = cards.get(0);
                cardDeck1.add(card);
                cardDeck.remove(card);
            }

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

}
