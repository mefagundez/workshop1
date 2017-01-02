package hello.interceptor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class HeaderExistValidator implements ValidatorInterceptor {

    private String headerName = "exist";
    private String validationMessage = "exist header does not exist";

    public String getHeaderParam(){
        return headerName;
    }
    public Predicate<? super String> getPredicate(){
        return s -> !s.isEmpty();
    }
    public String getValidationMessage(){
        return validationMessage;
    }
}