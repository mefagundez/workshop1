package hello.interceptor;
import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler. HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Component
public class HeaderValidator extends HandlerInterceptorAdapter {

    static{
        BasicConfigurator.configure();
    }

    @Autowired
    private ValidatorInterceptor[] validatorInterceptors;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        boolean validatorsInterceptorsResponse = Arrays.stream(validatorInterceptors).allMatch(validator -> {
            Optional<String> actualHeader = Optional.ofNullable(request.getHeader(validator.getHeaderParam()));
            if (actualHeader.isPresent()){
                return validator.getPredicate().test(actualHeader.get());
            } else {
                return false;
            }
        });
        System.out.println("-*-*-*-*-*-*---*-*-*validators interceptors response -> " + validatorsInterceptorsResponse);
        return super.preHandle(request, response, handler);
    }


}