package com.spring.ProgettoDemo.exception; // Pacchetto in cui è definita la classe di gestione delle eccezioni

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus; // Enum per specificare codici di stato HTTP
import org.springframework.http.ResponseEntity; // Classe per incapsulare la risposta HTTP
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler; // Annotazione per gestire specifiche eccezioni
import org.springframework.web.bind.annotation.RestControllerAdvice; // Annotazione per definire una classe che gestisce eccezioni globali nei controller REST

import com.spring.ProgettoDemo.dto.ErroreDTO; // DTO personalizzato per restituire dettagli sugli errori


@RestControllerAdvice // Indica che questa classe fornisce gestione globale delle eccezioni per i controller REST
public class GestoreErrori {
//SCRITTO DA ME
    // Metodo che gestisce tutte le eccezioni di tipo RuntimeException
//    @ExceptionHandler
//    public ResponseEntity<ErroreDTO> handler(RuntimeException exc){
//        // Crea un oggetto DTO dell'errore con il messaggio dell'eccezione
//        ErroreDTO error = new ErroreDTO(exc.getMessage());
//        
//        // Crea una risposta HTTP con stato 500 (errore interno) e corpo contenente l'oggetto errore
//        ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//        
//        // Restituisce la risposta
//        return response;
//    }
//
//    // Metodo che gestisce esplicitamente le NullPointerException
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErroreDTO> handleNullPointerException(NullPointerException exc) {
//        // Crea un oggetto DTO con un messaggio d'errore specifico per i null pointer
//        ErroreDTO error = new ErroreDTO("Si è verificato un errore di tipo NullPointerException");
//        
//        // Restituisce una risposta HTTP con stato 400 (Bad Request) e il messaggio d'errore
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
	//creato da gpt
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroreDTO> handleResourceNotFoundException(ResourceNotFoundException exc) {
        ErroreDTO error = new ErroreDTO(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErroreDTO> handleEntityAlreadyExistsException(EntityAlreadyExistsException exc) {
        ErroreDTO error = new ErroreDTO(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErroreDTO> handleNullPointerException(NullPointerException exc) {
        ErroreDTO error = new ErroreDTO("Si è verificato un errore di tipo NullPointerException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exc) {
        Map<String, String> errors = new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> handleGenericException(Exception exc) {
        ErroreDTO error = new ErroreDTO(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
