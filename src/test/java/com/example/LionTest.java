package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)

public class LionTest {
    private final String sex;
    private final Boolean expected;
    private Lion lion;

    public LionTest(String sex, Boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Feline feline;
    private Lion lionNoSex;


    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expected, actual);
        System.out.println("Тест метода testLionDoesHaveMane. Результат: Success");
    }

    @Test
    public void testLionDoesHaveManeException() throws Exception {
        Exception exception = null;
        try {
            Lion lionNoSex = new Lion("sex", feline);
            lionNoSex.doesHaveMane();
        } catch (Exception ex) {
            exception = ex;
        }
        assertNotNull(exception);
        assertEquals("Используйте допустимые значения пола животного - " + "самей или самка", exception.getMessage());
        System.out.println("Тест метода testLionDoesHaveManeException. Результат: Exception");
    }

    @Test
    public void testLionGetKittensCount() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = feline.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
        System.out.println("Тест метода testLionGetKittensCount. Результат: Success");
    }

}


