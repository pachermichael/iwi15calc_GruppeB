package at.edu.c02.calculator;


public interface Calculator {

	enum Operation {
		add, sub, mul, div, mod, sin, cos
	};

	void push(double value);
	
	double pop() throws CalculatorException;
	
	double perform(Operation op) throws CalculatorException;
	double perform(Operation op, double a) throws CalculatorException;
	
	void clear(); 
}
