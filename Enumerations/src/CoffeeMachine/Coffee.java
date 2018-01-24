package CoffeeMachine;

 class Coffee {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;

     Coffee(CoffeeType coffeeType,CoffeeSize coffeeSize) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
    }
    public int getPrice(){
        return this.coffeeSize.getPrice();
    }

     @Override
     public String toString() {
        String coffeeSize = this.coffeeSize.toString().charAt(0) + this.coffeeSize.toString().substring(1).toLowerCase();
        String coffeeType = this.coffeeType.toString().charAt(0) + this.coffeeType.toString().substring(1).toLowerCase();
         return String.format("%s %s", coffeeSize, coffeeType);
     }
 }
