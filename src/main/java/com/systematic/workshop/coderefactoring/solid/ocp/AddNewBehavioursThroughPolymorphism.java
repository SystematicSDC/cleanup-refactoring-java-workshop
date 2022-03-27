package com.systematic.workshop.coderefactoring.solid.ocp;

/**
 * A trivial example of a calculator implementation which solves OCP via polymorphism.
 * <p>
 * Any subsequent operation that is implement must fulfill the "perform" contract by implementing it, and it will
 * encapsulate the entire operation in the new class. Therefore, the "calculate" method doesn't need any changes.
 */
public class AddNewBehavioursThroughPolymorphism {

    // Method is closed for modification - if we want to implement SquareRoot, we just need to implement the
    // perform() method.
    public final void calculate(CalculatorOperation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Cannot perform operation");
        }
//        else if (operation instanceof SquareRoot) {
//            Math.sqrt(operation.getNumber());
//        }
        operation.perform();
    }

    public interface CalculatorOperation {
        // open for extension :)
        double perform();
    }

    class Add implements CalculatorOperation {
        private double left;
        private double right;

        @Override
        public double perform() {
            return left + right;
        }
    }

    class Divide implements CalculatorOperation {
        private double left;
        private double right;

        @Override
        public double perform() {
            if (right != 0) {
                return left / right;
            }
            throw new IllegalArgumentException("Cannot perform operation");
        }
    }
}
