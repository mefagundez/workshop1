package hello.interceptor;
import hello.exception.BadRequestException;
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
                if (validator.getPredicate().test(actualHeader.get())) return true;
                else throw new BadRequestException(validator.getValidationMessage());
            } else {
                throw new BadRequestException("Header " + validator.getHeaderParam() + " does NOT exist");
            }
        });
        return super.preHandle(request, response, handler);
    }


}