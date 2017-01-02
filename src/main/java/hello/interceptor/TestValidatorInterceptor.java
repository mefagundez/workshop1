package hello.interceptor;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class TestValidatorInterceptor implements ValidatorInterceptor {

    private String value = "TEST";
    private String validationMessage = "TEST Header is not equal to TEST";

    public String getHeaderParam(){
        return value;
    }
    public Predicate<? super String> getPredicate(){
        return s -> s.equals(value);
    }
    public String getValidationMessage(){
        return validationMessage;
    }
}
