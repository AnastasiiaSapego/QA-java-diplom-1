package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BurgerBaseOperationsTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsShouldStoreSameReference() {
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        Assert.assertSame(bun, burger.bun);

    }

    @Test
    public void addIngredientShouldAddInList() {
        Ingredient a = mock(Ingredient.class);
        Ingredient b = mock(Ingredient.class);
        Ingredient c = mock(Ingredient.class);
        burger.addIngredient(a);
        Assert.assertSame(a, burger.ingredients.get(0));
        Assert.assertEquals(1, burger.ingredients.size());
        burger.addIngredient(b);
        Assert.assertSame(b, burger.ingredients.get(1));
        Assert.assertEquals(2, burger.ingredients.size());
        burger.addIngredient(c);
        Assert.assertSame(c, burger.ingredients.get(2));
        Assert.assertEquals(3, burger.ingredients.size());

    }

    @Test
    public void removeIngredientShouldDeleteFromList() {
        Ingredient a = mock(Ingredient.class);
        Ingredient b = mock(Ingredient.class);
        Ingredient c = mock(Ingredient.class);
        burger.addIngredient(a);
        burger.addIngredient(b);
        burger.addIngredient(c);
        Assert.assertEquals(3, burger.ingredients.size());
        burger.removeIngredient(1);
        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertSame(a, burger.ingredients.get(0));
        Assert.assertSame(c, burger.ingredients.get(1));
        Assert.assertFalse(burger.ingredients.contains(b));
    }
}
