package at.edu.c02.calculator.logic;

import java.util.Stack;
import java.util.Vector;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {

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
			double dotproduct = 0;

			for (int i = 0; i < dimension; i++) {
				if(!stack_.isEmpty()){
					vector1.add(stack_.pop());
				}
			}
			for (int i = 0; i < dimension; i++) {
				if(!stack_.isEmpty()){
					vector2.add(stack_.pop());
				}
			}

			for (int i = 0; i < vector1.size(); i++) {
				dotproduct += vector1.elementAt(i) * vector1.elementAt(i);
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
	public void clear() {
		stack_.clear();
	}

}
