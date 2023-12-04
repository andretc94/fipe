package br.com.atcarvalho.api1.exceptions;

import br.com.atcarvalho.api1.api.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Error> notFound(NotFoundException ex) {
        ex.printStackTrace();
        Error error = new Error();
        error.code(BigDecimal.valueOf(HttpStatus.NOT_FOUND.value()));
        error.message(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Error> internalServerError(Exception ex) {
        ex.printStackTrace();
        Error error = new Error();
        error.code(BigDecimal.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.message(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
