package inventoryClassTests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class InventoryClassTests {

    private Inventory inventory;

    @Before
    public void before() throws NoSuchFieldException, IllegalAccessException {

        this.inventory = new HeroInventory();
        this.seedCommonItems();

    }

    @Test
    public void testTotalStrengthBonus(){
        this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(2, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testTotalAgilityBonus(){
        this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(2, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testTotalIntelligenceBonus(){
        this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testTotalHitPointsBonus(){
        this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testTotalDamageBonus(){
        this.inventory.getTotalStrengthBonus();
        Assert.assertEquals(2, this.inventory.getTotalIntelligenceBonus());
    }


    @Test
    public void testAddCommonItem() throws NoSuchFieldException, IllegalAccessException {
        this.seedRecipeItems();
        Item mock = Mockito.mock(Item.class);

        this.inventory.addCommonItem(mock);
        Field commonItemField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemField.get(this.inventory);

        Assert.assertEquals("Common Items length is not correct", 2L, commonItems.size());


    }

    @Test
    public void testAddRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        this.seedRecipeItems();
        Recipe mock = mock(Recipe.class);

        this.inventory.addRecipeItem(mock);
        Field recipeItemField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemField.setAccessible(true);
        Map<String, Item>recipeItems = (Map<String, Item>) recipeItemField.get(this.inventory);

        Assert.assertEquals(2, recipeItems.size());
    }





    @SuppressWarnings("unchecked")
    private void seedCommonItems() throws NoSuchFieldException, IllegalAccessException {
        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);
        Item mock1 = mock(Item.class);
        when(mock1.getStrengthBonus()).thenReturn(2);
        when(mock1.getAgilityBonus()).thenReturn(2);
        when(mock1.getDamageBonus()).thenReturn(2);
        when(mock1.getHitPointsBonus()).thenReturn(2);
        when(mock1.getIntelligenceBonus()).thenReturn(2);
        when(mock1.getName()).thenReturn("commonItemsMock1");

        Item mock2 = mock(Item.class);
        when(mock2.getStrengthBonus()).thenReturn(-2);
        when(mock2.getAgilityBonus()).thenReturn(-2);
        when(mock2.getDamageBonus()).thenReturn(-2);
        when(mock2.getHitPointsBonus()).thenReturn(-2);
        when(mock2.getIntelligenceBonus()).thenReturn(-2);
        when(mock2.getName()).thenReturn("commonItemsMock2");

        Item mock3 = mock(Item.class);
        when(mock3.getStrengthBonus()).thenReturn(2);
        when(mock3.getAgilityBonus()).thenReturn(2);
        when(mock3.getDamageBonus()).thenReturn(2);
        when(mock3.getHitPointsBonus()).thenReturn(2);
        when(mock3.getIntelligenceBonus()).thenReturn(2);
        when(mock3.getName()).thenReturn("commonItemsMock3");

        commonItems.put(mock1.getName(), mock1);
        commonItems.put(mock2.getName(), mock2);
        commonItems.put(mock3.getName(), mock3);
    }

    @SuppressWarnings("unchecked")
    private void seedRecipeItems() throws NoSuchFieldException, IllegalAccessException {
        Field recipeItemsField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemsField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.inventory);
        Recipe mock1 = mock(Recipe.class);
        when(mock1.getStrengthBonus()).thenReturn(2);
        when(mock1.getAgilityBonus()).thenReturn(2);
        when(mock1.getDamageBonus()).thenReturn(2);
        when(mock1.getHitPointsBonus()).thenReturn(2);
        when(mock1.getIntelligenceBonus()).thenReturn(2);
        when(mock1.getName()).thenReturn("recipeItemsMock1");
        String[] requiredItems = {"commonItemsMock1", "commonItemsMock2", "commonItemsMock3"};
        when(mock1.getRequiredItems()).thenReturn(Arrays.asList(requiredItems));
        recipeItems.put(mock1.getName(), mock1);
    }

}
