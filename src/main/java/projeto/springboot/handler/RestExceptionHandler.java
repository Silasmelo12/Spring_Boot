package projeto.springboot.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import projeto.springboot.exception.BadRequestException;
import projeto.springboot.exception.BadRequestExceptionDetails;
import projeto.springboot.exception.ValidationExceptionDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details(bre.getMessage())
                        .developerMessege(bre.getClass().getName())
                        .build(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException
            (MethodArgumentNotValidException exception){

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(" ,"));
        String fieldMessege= fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" ,"));
        log.info("Field {}",exception.getBindingResult().getFieldError().getField());
        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Check the Documentation")
                        .details("Cheque o corpo de erro")
                        .developerMessege(exception.getClass().getName())
                        .fields(fields)
                        .fieldMessage(fieldMessege)
                        .build(),HttpStatus.BAD_REQUEST);
    }
}
