package dio.lyusk8.labpadroesprojetospring.services;

import dio.lyusk8.labpadroesprojetospring.entities.Cliente;
import dio.lyusk8.labpadroesprojetospring.repositories.ClienteRepository;
import dio.lyusk8.labpadroesprojetospring.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService cepService;


    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(Cliente cliente) {
        var cep = cliente.getEndereco().getCep();
        var endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            var novoEndereco = cepService.consultar(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        return repository.save(cliente);
    }

    public void deletar(Long id){
        repository.delete(findById(id));
    }

    public Cliente atualizar(Cliente cliente){
       return repository.save(cliente);
    }
}
