package madstodolist.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Cliente no encontrado")
public class ClienteNotFoundException extends RuntimeException{
}
