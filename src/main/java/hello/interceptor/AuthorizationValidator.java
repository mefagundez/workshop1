package hello.interceptor;
import org.springframework.stereotype.Component;
import java.util.function.Predicate;

@Component
public class AuthorizationValidator implements ValidatorInterceptor {

    private String headerName = "Authorization";

    public String getHeaderParam(){
        return headerName;
    }
    public Predicate<? super String> getPredicate() {
        return s -> !s.isEmpty();
    }

}
