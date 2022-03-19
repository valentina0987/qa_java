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
    Lion lion;

    @Test
    public void shouldBeCorrectExceptionMessage() throws Exception {
        Lion li = new Lion("Самец");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> { throw new IllegalArgumentException("Используйте допустимые значения пола животного - самей или самка"); }
        );
        String expectedExceptionMessage = "Используйте допустимые значения пола животного - самей или самка";
        String actualExceptionMessage = exception.getMessage();
        Assert.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    public void shouldBe1Kitten() {
        Mockito.when(lion.getKittens()).thenReturn(1);
        int expectedKittenCount = 1;
        int actualKittenCount = lion.getKittens();
        Assert.assertEquals(expectedKittenCount, actualKittenCount);
    }

    @Test
    public void shouldBePredatorsFood() throws Exception {
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

}
