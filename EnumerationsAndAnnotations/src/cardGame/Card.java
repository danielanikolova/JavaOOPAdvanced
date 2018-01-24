package cardGame;


public class Card implements Comparable<Card>{
    private Suit suitPower;
    private Rank rankPower;

    public Card(Suit suitPower, Rank rankPower) {
        this.setSuitPower(suitPower);
        this.setRankPower(rankPower);
    }

    public Rank getRankPower() {
        return this.rankPower;
    }

    public Suit getSuitPower() {
        return this.suitPower;
    }

    public void setRankPower(Rank rankPower) {
        if (rankPower == null){
            throw new IllegalArgumentException("No such card exists.");
        }
        this.rankPower = rankPower;
    }

    public void setSuitPower(Suit suitPower) {
        if (suitPower == null){
            throw new IllegalArgumentException("No such card exists.");
        }
        this.suitPower = suitPower;
    }

    public int getCardPower(){
        return this.suitPower.getPower() + this.rankPower.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rankPower.name(), this.suitPower.name(),
                (this.rankPower.getPower()+this.suitPower.getPower())
                );
    }

    @Override
    public int compareTo(Card o) {

        return Integer.compare(this.getCardPower(),o.getCardPower());
    }
}
