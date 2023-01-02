package at.edu.c02.calculator.logic;

import at.edu.c02.calculator.StorageException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StorageTest {

	@Test
	public void testStorageOverwrite() {
		Storage storage = new Storage();
		storage.store(123,"A");
		storage.store(312,"A");
		try{
			double valueA = storage.load("A");
			assertEquals(312,valueA,0);
		}
		catch (StorageException ex){
			assertEquals("No value with this key found.", ex.getMessage());
		}
	}

	@Test
	public void testStorageMultiple() {
		Storage storage = new Storage();
		storage.store(123,"A");
		storage.store(312,"B");
		try{
			double valueA = storage.load("A");
			double valueB = storage.load("B");
			assertEquals(123,valueA,0);
			assertEquals(312,valueB,0);
		}
		catch (StorageException ex){
			assertEquals("No value with this key found.", ex.getMessage());
		}
	}

	@Test
	public void testStorageWithNoKey() {
		Storage storage = new Storage();
		double value = 0;
		try {
			storage.store(34,"A");
			value = storage.load("X");
		} catch (StorageException e) {
			assertEquals("No value with this key found.", e.getMessage());
		}
	}
}
