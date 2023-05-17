package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = { EntityNotFoundException.class })
  // @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> noEntityFoundHandler(Exception ex) {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ValidationErrorsDto>> NotValidBodyHandler(
    MethodArgumentNotValidException e
  ) {
    List<ValidationErrorsDto> errors = e
      .getFieldErrors()
      .stream()
      .map(ValidationErrorsDto::new)
      .toList();

    return ResponseEntity.badRequest().body(errors);
  }

  private record ValidationErrorsDto(String field, String error) {
    public ValidationErrorsDto(FieldError error) {
      this(error.getField(), error.getDefaultMessage());
    }
  }
}
