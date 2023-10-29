package dio.lyusk8.labpadroesprojetospring.controllers;

import dio.lyusk8.labpadroesprojetospring.controllers.dto.ClienteDto;
import dio.lyusk8.labpadroesprojetospring.entities.Cliente;
import dio.lyusk8.labpadroesprojetospring.services.ClienteService;
import dio.lyusk8.labpadroesprojetospring.services.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;
    private final ViaCepService cepservice;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDto clienteDto){
        var endereco = cepservice.consultar(clienteDto.getCep());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDto.parseEntity(endereco)));
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(service.atualizar(cliente));
    }


    @DeleteMapping("/id")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
