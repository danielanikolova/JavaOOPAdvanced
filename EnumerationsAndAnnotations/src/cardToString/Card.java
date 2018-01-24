package cardToString;

public class Card {
    private SuitPower suitPower;
    private RankPower rankPower;

    public Card(SuitPower suitPower, RankPower rankPower) {
        this.suitPower = suitPower;
        this.rankPower = rankPower;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rankPower.name(), this.suitPower.name(),
                (this.rankPower.getPower()+this.suitPower.getPower())
                );
    }
}
