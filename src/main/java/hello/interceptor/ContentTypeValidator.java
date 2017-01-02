package hello.interceptor;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class ContentTypeValidator implements ValidatorInterceptor {
    private String headerName = "Content-Type";
    private String headerValue = "application/json";
    private String validationMessage = "Content type is not valid";

    public String getHeaderParam(){
        return headerName;
    }
    public Predicate<? super String> getPredicate() {
        return s -> s.equals(headerValue);
    }
    public String getValidationMessage() {
        return validationMessage;
    }
}
