package com.example;

import com.example.Animal;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)

public class AnimalTest {

    private Animal animal;

    @Spy
    private Animal animalSpy = new Animal();

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testAnimalEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = animalSpy.getFood("Хищник");
        assertEquals(expected, actual);
        System.out.println("Тест метода testAnimalEatMeat. Результат: Success");

    }

    @Test
    public void testAnimalEatGrass() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animalSpy.getFood("Травоядное");
        assertEquals(expected, actual);
        System.out.println("Тест метода testAnimalEatGrass. Результат: Success");

    }

    @Test

    public void testAnimalException() {
        Animal animal = new Animal();
        Exception exception = null;
        try {
            animal.getFood("Неизвестный вид");
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        System.out.println("Тест метода testAnimalException. Результат: Exception");
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        TestCase.assertEquals(expectedFamily, actualFamily);
        System.out.println("Тест метода testGetFamily. Результат: Success");
    }
}