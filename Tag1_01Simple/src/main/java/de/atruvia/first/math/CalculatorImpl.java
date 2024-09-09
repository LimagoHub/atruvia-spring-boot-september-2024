package de.atruvia.first.math;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Qualifier("impl")
@Lazy
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
