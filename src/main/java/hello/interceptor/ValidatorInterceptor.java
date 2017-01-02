package hello.interceptor;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public interface ValidatorInterceptor {
    String getHeaderParam();
    Predicate<? super String> getPredicate();
    String getValidationMessage();
}
