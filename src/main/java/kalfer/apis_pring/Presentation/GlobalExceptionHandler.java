package kalfer.apis_pring.Presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kalfer.apis_pring.Application.Common.Result;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Object>> handleGeneralException(Exception ex) {
        // Log de error, etc.
        Result<Object> result = Result.Error("An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Result<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Result<Object> result = Result.Error(ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Result<Object>> handleValidationException(ValidationException ex) {
        Result<Object> result = Result.Error(ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }*/
    
}
