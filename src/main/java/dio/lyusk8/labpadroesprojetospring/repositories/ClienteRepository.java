package dio.lyusk8.labpadroesprojetospring.repositories;

import dio.lyusk8.labpadroesprojetospring.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
