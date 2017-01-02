package hello.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity exception(BadRequestException ex,
                          HttpServletRequest request, HttpServletResponse response) throws IOException{
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.PRECONDITION_FAILED);
    }

}
