import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data: {0}, {1}")
    public static Object[][] getData(){
        return new Object[][]{
                {"short", 120.05f},
                {"Loooooooooooooooooooooooooooooooooooong Test Name", 15600029.00f},
                {"just name with int - 123456", 1000505}
        };
    }

    @Test
    public void checkGetName(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
