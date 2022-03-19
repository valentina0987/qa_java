package com.example;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    private Cat cat;

    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        cat = new Cat(feline);
    }

    @Test

    public void testCatGetFood() throws Exception {

        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
//        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        System.out.println("Тест метода testCatGetFood. Результат: Success");
    }

    @Test
    public void testCatGetFoodException() {
        try {
            Cat cat = new Cat(feline);
            Mockito.when(cat.getFood()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        } catch (Exception exception) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
            System.out.println("Тест метода testCatGetFoodException. Результат: Exception");
        }
    }

    @Test
    public void testCatGetSound() {
        String expected = cat.getSound();
        String actual = "Мяу";
        assertEquals(expected, actual);
        System.out.println("Тест метода testCatGetSound. Результат: Success");

    }

}