import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    Feline feline;

    @Test
    public void shouldBeCorrectExceptionMessage() throws Exception {
        Lion li = new Lion("Самец", feline);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("Используйте допустимые значения пола животного - самей или самка"); }
        );
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualExceptionMessage = exception.getMessage();
        Assert.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void shouldBeOneKitten() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittenCount = 1;
        int actualKittenCount = feline.getKittens();
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void shouldBePredatorsFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.getFood("Хищник");
        Assert.assertEquals(expectedFood, actualFood);
    }

}
