package at.edu.c02.calculator.logic;

import java.util.Stack;
import java.util.Vector;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.StorageException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();
	private Storage storage_ = new Storage();

	@Override
	public double perform(Operation op) throws CalculatorException {

		//Anpassung der perform für sin, cos, scalar

		if (op.name().equals("sin") || op.name().equals("cos")) {
			double a = pop();

			switch (op) {
				case sin:
					return Math.sin(a);
				case cos:
					return Math.cos(a);
			}
			return 0;
		}else if(op.name().equals("scalar")){

			/**
			 Erklärung:

			 Bsp.: Wir haben 9 Werte am Stack und der letzte ist die Dimension unseres Vectors -> in dem Fall 4

			 double dimension nimmt jetzt mit stack_.pop() die Dimension also 4

			 Jetzt sind die restlichen 8 Werte am Stack double Werte für unsere Vectoren

			 Mit den 2 Schleifen werden jetzt jeweils 4 Werte auf 2 Vectoren verteilt:
			 	- 1. Vector (Wert - 8, 7, 6, 5)
			 	- 2. Vector (Wert - 4, 3, 2, 1)

			 Nun sollte der Stack leer bzw. wie vor der Operation sein. (Kann sein das das zu Bugs führt - check ich noch)

			 mit den Vectoren errechnen wir jetzt das dotproduct und returnen es
			 **/
			Vector<Double> vector1 = new Vector<Double>();
			Vector<Double> vector2 = new Vector<Double>();

			double dimension = stack_.pop();
			if(dimension < 0){
				throw new CalculatorException("dimension smaller zero");
			}
			double dotproduct = 0;

			for (int i = 0; i < dimension; i++) {
					vector1.add(pop());
			}
			for (int i = 0; i < dimension; i++) {
					vector2.add(pop());
			}

			//Berechnung des Skalarproducts
			for (int i = 0; i < vector1.size(); i++) {
				dotproduct += vector1.elementAt(i) * vector2.elementAt(i);
			}

			return dotproduct;

		}else{
			double b = pop();
			double a = pop();

			switch (op) {
				case add:
					return a + b;
				case sub:
					return a - b;
				case div:
					double c = a / b;
					if (Double.isInfinite(c))
						throw new CalculatorException("Division by zero");
					return c;
				case mul:
					return a * b;
				case mod:
					return a % b;
				case sin:
					return Math.sin(a);
				case cos:
					return Math.cos(a);
			}
			return 0;
		}
	}


	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}
	@Override
	public void store(double value) {storage_.store(value);}
	@Override
	public void store(double value, String name) { storage_.store(value,name);}
	@Override
	public double load(String name) throws StorageException {return storage_.load(name);}
	@Override
	public double load() {return storage_.load();}
	@Override
	public void clear() {
		stack_.clear();
	}

}
