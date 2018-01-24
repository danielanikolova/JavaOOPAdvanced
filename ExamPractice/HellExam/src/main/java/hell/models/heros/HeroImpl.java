package hell.models.heros;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;


public abstract class HeroImpl implements Hero{

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected HeroImpl(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() throws NoSuchMethodException, IllegalAccessException {

        Collection<Item> items = null;
        Field field = HeroInventory.class.getDeclaredFields()[0];
        if (field.isAnnotationPresent(ItemCollection.class)){
            field.setAccessible(true);

            try {
                Map<String, Item> itemsInventory = (Map<String, Item>) field.get(this.inventory);
               return items = itemsInventory.values();
            }catch (IllegalAccessException ex){
                ex.printStackTrace();
            }


        }
        return items;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("###HitPoints: %s", this.getHitPoints())).append(System.lineSeparator());
        sb.append(String.format("###Damage: %s", this.getDamage())).append(System.lineSeparator());
        sb.append(String.format("###Strength: %s", this.getStrength())).append(System.lineSeparator());
        sb.append(String.format("###Agility: %s", this.getAgility())).append(System.lineSeparator());
        sb.append(String.format("###Intelligence: %s", this.getIntelligence())).append(System.lineSeparator());

        Collection<Item> items = null;
        try {
            items = this.getItems();
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.append("###Items: ");
        sb.append(items.size() == 0 ? "None" :
                String.join(", ", items.stream().map(Item::getName).collect(Collectors.toList())))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
