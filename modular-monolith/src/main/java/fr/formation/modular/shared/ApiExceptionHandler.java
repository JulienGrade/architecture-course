package fr.formation.modular.shared;
import java.util.Map; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestControllerAdvice public class ApiExceptionHandler { @ExceptionHandler(BusinessException.class) ResponseEntity<Map<String,String>> business(BusinessException e){return ResponseEntity.unprocessableEntity().body(Map.of("message",e.getMessage()));} @ExceptionHandler(NotFoundException.class) ResponseEntity<Map<String,String>> missing(NotFoundException e){return ResponseEntity.status(404).body(Map.of("message",e.getMessage()));} }
