package hell.commands;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Recipe;
import hell.models.heros.Assassin;
import hell.models.heros.Barbarian;
import hell.models.heros.Wizard;
import hell.interfaces.Item;
import hell.models.items.CommonItem;
import hell.models.items.RecipeItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandInterpreterImpl implements CommandInterpreter{

    private Map<String, Hero> heros;

    public CommandInterpreterImpl() {
        this.heros = new LinkedHashMap<>();
    }
    @Override
    public String createHero(List<String> params) {
        Hero hero = null;
        String name = params.get(1);
        String type = params.get(2);
        switch (type){
            case "Barbarian":
                hero = new Barbarian(name, 90, 25, 10, 350, 150, new HeroInventory());
                break;
            case "Assassin":
                hero = new Assassin(name, 25,100,15,150,300, new HeroInventory());
                break;
            case "Wizard":
                hero = new Wizard(name,25,25,100,100,250, new HeroInventory());
                break;
        }
        this.heros.put(name, hero);
        return String.format("Created %s - %s", type, name);
    }

    @Override
    public String createItem(List<String> params) {
        String name = params.get(1);
        String hero = params.get(2);

        Item item = new CommonItem(name, Integer.parseInt(params.get(3)),Integer.parseInt(params.get(4)),Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6)),Integer.parseInt(params.get(7)));
        if (this.heros.containsKey(hero)){
            this.heros.get(hero).addItem(item);
        }

        return String.format("Added item - %s to Hero - %s", name, hero);
    }

    @Override
    public String createRecipe(List<String> params) {
        String name = params.get(1);
        String hero = params.get(2);
        List<String> requiredItems = params.subList(8, params.size());

        Recipe recipe = new RecipeItem(name, Integer.parseInt(params.get(3)),Integer.parseInt(params.get(4)),Integer.parseInt(params.get(5)),
                Integer.parseInt(params.get(6)),Integer.parseInt(params.get(7)), requiredItems);
        if (this.heros.containsKey(hero)){
            this.heros.get(hero).addRecipe(recipe);
        }
        return String.format("Added recipe - %s to Hero - %s", name, hero);
    }

    @Override
    public String inspectCommand(List<String> param) throws NoSuchMethodException, IllegalAccessException {
        Hero hero = this.heros.get(param.get(1));
        String endOfString = null;
        if (hero.getItems().size()==0){
            endOfString = "Items: None";
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append("Items:\n");
            for (Item item : hero.getItems()) {
                sb.append(String.format("###Item: %s\n", item.getName()));
                sb.append(String.format("###+%d Strength\n", item.getStrengthBonus()));
                sb.append(String.format("###+%d Agility\n", item.getAgilityBonus()));
                sb.append(String.format("###+%d Intelligence\n", item.getIntelligenceBonus()));
                sb.append(String.format("###+%d HitPoints\n", item.getHitPointsBonus()));
                sb.append(String.format("###+%d Damage\n", item.getDamageBonus()));

            }

            endOfString = sb.toString().trim();
        }

        return "Hero: "+hero.getName()+", Class: "+hero.getClass().getSimpleName()+"\n" +
                "HitPoints: "+hero.getHitPoints()+", Damage: "+hero.getDamage()+"\n" +
                "Strength: "+hero.getStrength()+"\n" +
                "Agility: "+hero.getAgility()+"\n" +
                "Intelligence: "+hero.getIntelligence()+"\n" +
                endOfString;
    }

    @Override
    public String quitCommand() {
        StringBuilder sb = new StringBuilder();

        final int[] heroIndex = {0};

        heros.values().stream().sorted((a,b)->{
            long firstParamsA = a.getStrength() + a.getAgility() + a.getIntelligence();
            long firstParamsB = b.getStrength() + b.getAgility() + b.getIntelligence();

            if (Long.compare(firstParamsA, firstParamsB) == 0){
                long hitPointsA = a.getHitPoints() + a.getDamage();
                long hitPointsB = b.getHitPoints() + b.getDamage();
                return Long.compare(hitPointsB, hitPointsA);
            }else {
                return Long.compare(firstParamsB, firstParamsA);
            }


        }).forEach(hero-> {
            sb.append(String.format("%d. %s: %s", ++heroIndex[0], hero.getClass().getSimpleName(),
                    hero.getName())).append(System.lineSeparator());

            sb.append(hero.toString());
        });

        return sb.toString();
    }
}
