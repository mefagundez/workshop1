package hello.interceptor;
import org.springframework.stereotype.Component;
import java.util.function.Predicate;

@Component
public class AuthorizationValidator implements ValidatorInterceptor {

    private String headerName = "Authorization";
    private String validationMessage = "Authorization header is empty";

    public String getHeaderParam(){
        return headerName;
    }
    public Predicate<? super String> getPredicate() {
        return s -> !s.isEmpty();
    }
    public String getValidationMessage() {
        return validationMessage;
    }
}
