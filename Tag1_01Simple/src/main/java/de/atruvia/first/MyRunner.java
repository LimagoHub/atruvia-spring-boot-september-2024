package de.atruvia.first;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order( 100)
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Hallo Welt");
    }
}
