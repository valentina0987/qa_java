package com.example;

import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    private Feline feline;

    @Spy
    private Feline felineSpy = new Feline();

    @Mock
    private Predator predator;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
        System.out.println("Тест метода testFelineEatMeat. Результат: Success");

    }

    @Test
    public void testFelineGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
        System.out.println("Тест метода testFelineGetFamily. Результат: Success");
    }

    @Test
    public void testFelineGetKittensCount() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
        System.out.println("Тест метода testFelineGetKittensCount. Результат: Success");
    }

}