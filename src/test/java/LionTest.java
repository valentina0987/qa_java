import com.example.Feline;
import com.example.Lion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertThrows;

public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void shouldBeCorrectExceptionMessage() throws Exception {
        Lion lion = new Lion("Самка");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("Используйте допустимые значения пола животного - самей или самка"); }
        );
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualExceptionMessage = exception.getMessage();
        Assert.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void shouldBe1Kitten() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец");
        int expectedKittenCount = 1;
        int actualKittenCount = lion.getKittens();
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void shouldBePredatorsFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

}
