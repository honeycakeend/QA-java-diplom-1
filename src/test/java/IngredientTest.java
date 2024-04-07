import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;

    private final String name;
    private final float price;
    private final IngredientType type;

    public IngredientTest(IngredientType type, String name, float price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Before
    public void setIngredient(){
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataTest(){
        return Arrays.asList(new Object[][]{
            {IngredientType.FILLING, "filling", 100},
            {IngredientType.SAUCE, "sauce", 200}
        });
    }

    @Test
    public void checkGetPriceIngredient(){
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetNameIngredient(){
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void checkGetTypeIngredient(){
        Assert.assertEquals(type, ingredient.getType());
    }
}
