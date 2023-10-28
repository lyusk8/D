package dio.lyusk8.labpadroesprojetospring.services;

import dio.lyusk8.labpadroesprojetospring.entities.Endereco;
import dio.lyusk8.labpadroesprojetospring.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco findById(String id) {
        return repository.findById(id).get();
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

    public void deletar(String id){
        repository.delete(findById(id));
    }

    public Endereco atualizar(Endereco endereco){
        return repository.save(endereco);
    }
}
