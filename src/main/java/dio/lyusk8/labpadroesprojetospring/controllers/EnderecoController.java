package dio.lyusk8.labpadroesprojetospring.controllers;

import dio.lyusk8.labpadroesprojetospring.entities.Endereco;
import dio.lyusk8.labpadroesprojetospring.services.EnderecoService;
import dio.lyusk8.labpadroesprojetospring.services.ViaCepService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService service;

    private final ViaCepService cepService;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Endereco> salvar(@PathVariable() String id){
        Endereco endereco = cepService.consultar(id);
        return ResponseEntity.ok(service.save(endereco));
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){
        return ResponseEntity.ok(service.atualizar(endereco));
    }


    @DeleteMapping("/id")
    public void deletar(@PathVariable String id){
        service.deletar(id);
    }
}
