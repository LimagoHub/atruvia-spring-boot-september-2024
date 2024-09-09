package de.atruvia.first.demo;


import de.atruvia.first.translator.Translator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Lazy
@RequiredArgsConstructor
public class Demo {

    @Value("${Demo.message}")
    private final String message;

    @Qualifier("upper") @NonNull
    private final Translator translator;

   /*public Demo(@Qualifier("upper") final Translator translator) {
        this.translator = translator;
        System.out.println(message);
    }
    */
    @PostConstruct
    public void init() {
        System.out.println(translator.translate("Init: " + message));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }
}
