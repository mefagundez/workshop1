package hello.interceptor;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class TestValidatorInterceptor implements ValidatorInterceptor {
    private String value = "TEST";
    public String getHeaderParam(){
        return value;
    }
    public Predicate<? super String> getPredicate(){
        return s -> s.equals(value);
    }
}
