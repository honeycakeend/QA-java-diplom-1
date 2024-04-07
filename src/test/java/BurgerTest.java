import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    @Before
    public void setBurgerTest(){
        burger = new Burger();
    }

    @Test
    public void checkSetBun(){
        burger.setBuns(mockBun);
        Assert.assertEquals(mockBun, burger.bun);
    }

    @Test
    public void checkGetPrice(){
        float price = 10f;
        Mockito.when(mockBun.getPrice()).thenReturn(10f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(price);
        Mockito.reset(mockBun);
        Mockito.reset(mockIngredient);
    }

    @Test
    public void checkAddIngredient(){
        burger.addIngredient(mockIngredient);
        Assert.assertTrue(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void checkRemoveIngredient(){
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void checkReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "filling", 10f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sauce", 20f));
        String pendingReceipt = burger.getReceipt();
        Assert.assertEquals(pendingReceipt, burger.getReceipt());
    }

    @Test
    public void checkMoveIngredient(){
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "test filling", 10f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "test sauce", 20f));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("test filling", burger.ingredients.get(1).name);
    }

}
