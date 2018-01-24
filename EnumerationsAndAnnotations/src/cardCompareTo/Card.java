package cardCompareTo;

public class Card implements Comparable<Card>{
    private SuitPower suitPower;
    private RankPower rankPower;
    private int cardPower;


    public Card(SuitPower suitPower, RankPower rankPower) {
        this.suitPower = suitPower;
        this.rankPower = rankPower;
        this.setCardPower();
    }

    private void setCardPower() {
        this.cardPower = this.rankPower.getPower()+this.suitPower.getPower();
    }

    public int getCardPower() {
        return this.cardPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rankPower.name(), this.suitPower.name(),
                this.cardPower
                );
    }


    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getCardPower(), o.getCardPower());
    }

}
