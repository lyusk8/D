package dio.lyusk8.labpadroesprojetospring.controllers.dto;

import dio.lyusk8.labpadroesprojetospring.entities.Cliente;
import dio.lyusk8.labpadroesprojetospring.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public
class ClienteDto {

    private String nome;
    private String cep;

    public Cliente parseEntity (Endereco endereco){
        return Cliente.builder().nome(nome).endereco(endereco).build();
    }
}