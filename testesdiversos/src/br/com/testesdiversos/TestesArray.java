package br.com.testesdiversos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TestesArray {
	
	@Test
    public void testAnyMatch1() {
        // Create list
        List<Integer> ls = Arrays.asList(8, 4, 5, 6, 7);
        
        System.out.println(1 % 2);
        System.out.println(3 % 2);
 
        // function to check whether all elements are divisible by 2.
        boolean result = ls.stream().anyMatch(n -> {
            System.out.println("O valor verificado: " + n);
            return n % 2 == 0;
        });

        assertTrue(result);
    }	
	
	@Test
    public void testAnyMatch2() {
        // Create list
        List<String> ls = Arrays.asList("Receitas", "de", "Código", "Stream", "anyMatch");

        boolean result = ls.stream().anyMatch(name -> {
            System.out.println("Verify: " + name);
            return name.length() > 5;
        });

        assertTrue(result);
    }	
	
	@Test
    public void testAnyMatch3() {
        // Create list
        Stream<Person> personStream = Stream.of(new Person("Wolmir", 32), new Person("Cesar", 20));

        boolean result = personStream.anyMatch(person -> person.getAge() < 18);

        assertFalse(result);
    }

    @Data
    @AllArgsConstructor
    public class Person {
        private String name;
        private Integer age;
    }	

}
