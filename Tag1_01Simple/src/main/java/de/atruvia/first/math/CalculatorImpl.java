package de.atruvia.first.math;

public class CalculatorImpl implements Calculator {
    @Override
    public double add(final double a, final double b) {
        return a + b;
    }

    @Override
    public double sub(final double a, final double b) {
        return add(a, -b);
    }
}
