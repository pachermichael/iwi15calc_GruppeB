package at.edu.c02.calculator.end2end;

import static org.junit.Assert.assertEquals;
import at.edu.c02.calculator.StorageException;
import at.edu.c02.calculator.parser.Parser;
import org.junit.Test;
import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.logic.CalculatorImpl;

import java.io.File;

public class End2EndTest {

    @Test
    public void testMultipleOperations1() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test05.xml"));

        //verify
        assertEquals(14, result, 0);
    }

    @Test
    public void testMultipleOperations2() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test06.xml"));

        //verify
        assertEquals(1, result, 0);
    }

    @Test
    public void testMultipleOperations3() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test08.xml"));

        //verify
        assertEquals(Math.sin(90), result, 0);
    }

    @Test
    public void testStoreLoadSingle() throws Exception{
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test09.xml"));

        //verify
        assertEquals(65, result, 0);
    }
    @Test
    public void testStoreLoadMultipleSuccess() throws Exception{
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test10.xml"));

        //verify
        assertEquals(99, result, 0);
    }
    @Test
    public void testStoreLoadMultipleFail() throws Exception{
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        try{
            double result = parser.parse(new File("src/test/resources/test11.xml"));
        }
         catch (StorageException e) {
            assertEquals("No value with this key found.", e.getMessage());
        }
    }

    @Test
    public void testdotproduct() throws Exception{
        //setup
        Calculator calc = new CalculatorImpl();
        Parser parser = new Parser(calc);
        //execute
        double result = parser.parse(new File("src/test/resources/test12.xml"));

        //verify
        assertEquals(44, result, 0);
    }
}
