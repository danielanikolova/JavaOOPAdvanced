package CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coin> coins;
    private List<Coffee>coffees;

    public CoffeeMachine() {
        this.coins = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());

        Coffee coffee = new Coffee(coffeeType, coffeeSize);

        int price = coffee.getPrice();

        int coinsSum = this.coins.stream().mapToInt(Coin::getValue).sum();

        if (coinsSum>=price){
            this.coffees.add(coffee);
            this.coins.clear();
        }

    }
    public void insertCoin(String coin) {
        Coin coin1 = Enum.valueOf(Coin.class, coin.toUpperCase());
        this.coins.add(coin1);
    }
    public Iterable<Coffee> coffeesSold(){
        return this.coffees;
    }
}
