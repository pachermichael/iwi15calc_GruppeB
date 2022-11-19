package at.edu.c02.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.logic.CalculatorImpl;

public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		//setup
		Calculator calc = new CalculatorImpl();
		
		//execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.add);

		//verify
		assertEquals(5, result, 0);
		

	}
	
	@Test
	public void testSimpleMulOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.mul);

		assertEquals(6, result, 0);

	}
	
	@Test
	public void testSimpleDivOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(6.0);
		calc.push(2);
		double result = calc.perform(Operation.div);

		assertEquals(3, result, 0);

	}


	@Test
	public void testSimpleModOperation() throws Exception{

		Calculator calc = new CalculatorImpl();
		calc.push(5);
		calc.push(2);
		double result = calc.perform(Operation.mod);

		assertEquals(1, result, 0);

	}

	@Test
	public void testSimpleModOperation2() throws Exception{

		Calculator calc = new CalculatorImpl();
		calc.push(2484);
		calc.push(231);
		double result = calc.perform(Operation.mod);

		assertEquals(174, result, 0);

	}

	@Test
	public void testSimpleSineOperation() throws Exception{

		Calculator calc = new CalculatorImpl();
		calc.push(90);

		double result = calc.perform(Operation.sin, 0);

		assertEquals(Math.sin(90), result, 0);
	}

	@Test
	public void testSimpleSineOperation2() throws Exception{

		Calculator calc = new CalculatorImpl();
		calc.push(180);

		double result = calc.perform(Operation.sin, 0);

		assertEquals(Math.sin(180), result, 0);
	}


	//
	@Test(expected = CalculatorException.class)
	public void testPopOnEmptyStack() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.pop();

	}

	@Test
	public void testDivisionByZero() throws Exception {

		//Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.div);

			fail("Exception expected");
			

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}
	}
	@Test
	public void testModByZero() throws Exception {

		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.mod);


		} catch (CalculatorException e) {
			assertEquals("Modulo by zero", e.getMessage());
		}

	}


}
