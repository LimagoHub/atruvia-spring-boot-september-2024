package de.atruvia.first;


import de.atruvia.first.math.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order( 100)
@RequiredArgsConstructor
public class MyRunner implements CommandLineRunner {
    @Qualifier("logger")
    private final Calculator calculator;

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(calculator.add(3,4));
    }
}
