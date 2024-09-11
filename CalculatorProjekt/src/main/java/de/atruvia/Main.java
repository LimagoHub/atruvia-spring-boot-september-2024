package de.atruvia;

import de.atruvia.common.LoggerProxy;
import de.atruvia.math.Calculator;
import de.atruvia.math.CalculatorImpl;
import de.atruvia.math.CalculatorLogger;
import de.atruvia.math.CalculatorSecure;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        //calculator = new CalculatorLogger(calculator);
        calculator = (Calculator) LoggerProxy.newInstance(calculator);
        calculator = new CalculatorSecure(calculator);
        System.out.println(calculator.sub(3,4));
    }
}