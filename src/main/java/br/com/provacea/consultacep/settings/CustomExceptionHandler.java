package br.com.provacea.consultacep.settings;

import br.com.provacea.consultacep.dto.CustomExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<CustomExceptionDto> handleRuntimeException(RuntimeException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CustomExceptionDto(message, HttpStatus.BAD_REQUEST));
    }

}
