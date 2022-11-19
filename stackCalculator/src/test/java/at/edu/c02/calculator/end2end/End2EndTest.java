package at.edu.c02.calculator.end2end;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import at.edu.c02.calculator.parser.Parser;
import org.junit.Test;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.Calculator.Operation;
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
}
