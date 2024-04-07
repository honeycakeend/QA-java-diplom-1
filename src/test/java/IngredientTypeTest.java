import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters(name = "Type: {0}")
    public static Collection<Object[]> dataTest() {
        return Arrays.asList(new Object[][]{
            {"SAUCE"},
            {"FILLING"}
        });
    }

    private final String type;

    public IngredientTypeTest(String type){
        this.type = type;
    }

    @Test
    public void checkEnumIngredientType(){
        assertNotNull(type, IngredientType.valueOf(type));
    }

    @Test
    public void checkNumberOfValuesIngredientType(){
        assertEquals(2, IngredientType.values().length);
    }
}
