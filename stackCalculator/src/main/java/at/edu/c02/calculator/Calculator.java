package at.edu.c02.calculator;


public interface Calculator {

	enum Operation {
		add, sub, mul, div, mod, sin, cos, dotproduct
	};

	void push(double value);
	void store(double value);
	void store(double value, String name) throws StorageException;
	double load(String name) throws StorageException;
	double load();
	double pop() throws CalculatorException;
	double perform(Operation op) throws CalculatorException;
	void clear(); 
}
