package de.atruvia.first.demo;


import de.atruvia.first.translator.Translator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Lazy
@RequiredArgsConstructor
public class Demo {


    //@Qualifier("upper") @NonNull
    private final Translator translator;

   /* public Demo(@Qualifier("upper") final Translator translator) {
        this.translator = translator;
    }
    */
    @PostConstruct
    public void init() {
        System.out.println(translator.translate("Init"));
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }
}
