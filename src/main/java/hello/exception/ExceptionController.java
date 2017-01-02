package hello.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = BadRequestException.class)
    public void exception(BadRequestException ex,
                          HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Exception in controller caught!---------------------------------------");
        response.sendError(HttpStatus.PRECONDITION_FAILED.value(),"message");
    }

}
