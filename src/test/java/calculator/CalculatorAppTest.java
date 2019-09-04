package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.LinkedHashMap;


public class CalculatorAppTest {
    @Test
    public void shouldAnswerWithTrue() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        list.put("add", 2);
        list.put("multiply", 3);
        list.put("apply", 10);
        assertEquals(36, (int) CalculatorApp.process(list));
    }

    @Test
    public void shouldAnswerWithTrue2() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        list.put("multiply", 3);
        list.put("add", 2);
        list.put("apply", 10);
        assertEquals(32, (int) CalculatorApp.process(list));
    }

    @Test
    public void shouldAnswerWithTrue3() {
        LinkedHashMap<String, Integer> list = new LinkedHashMap<>();
        list.put("apply", 1);
        assertEquals(1, (int) CalculatorApp.process(list));
    }

}
