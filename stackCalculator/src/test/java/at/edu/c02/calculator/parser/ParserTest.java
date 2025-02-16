package at.edu.c02.calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));
		
		verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.add);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest04Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test04.xml"));

		verify(cal).push(10.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.mod);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest07Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test07.xml"));

		verify(cal).push(30.0);
		verify(cal).perform(Operation.sin);

		verifyNoMoreInteractions(cal);
	}
	@Test
	public void testParserTest12Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test12.xml"));

		verify(cal).push(10.0);
		verify(cal).push(20.0);

		verify(cal).push(30.0);
		verify(cal).push(40.0);

		verify(cal).push(2.0);
		verify(cal).perform(Operation.dotproduct);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest13Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test13.xml"));

		verify(cal).push(5.0);
		verify(cal).push(7.0);

		verify(cal).push(6.0);
		verify(cal).push(4.0);

		verify(cal).push(2.0);
		verify(cal).perform(Operation.dotproduct);

		verifyNoMoreInteractions(cal);
	}
}
