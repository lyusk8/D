package dio.lyusk8.labpadroesprojetospring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_cep")
    private Endereco endereco;

    public Cliente() {
    }
}
