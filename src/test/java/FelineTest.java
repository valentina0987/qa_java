import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void shouldBePredatorsFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }
    
    @Test
    public void shouldBeFeline() {
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void should1Kitten() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void should10Kitten() {
        Feline feline = new Feline();
        int expectedKittensCount = 10;
        int actualKittensCount = feline.getKittens(10);
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

}
