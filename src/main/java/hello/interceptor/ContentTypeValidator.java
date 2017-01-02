package hello.interceptor;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class ContentTypeValidator implements ValidatorInterceptor {
    private String headerName = "Content-Type";
    private String headerValue = "application/json";

    public String getHeaderParam(){
        return headerName;
    }
    public Predicate<? super String> getPredicate() {
        return s -> s.equals(headerValue);
    }

}
