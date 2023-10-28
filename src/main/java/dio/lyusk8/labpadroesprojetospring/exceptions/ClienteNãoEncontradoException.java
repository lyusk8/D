package dio.lyusk8.labpadroesprojetospring.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteNãoEncontradoException extends Exception {

    public String message;
}
