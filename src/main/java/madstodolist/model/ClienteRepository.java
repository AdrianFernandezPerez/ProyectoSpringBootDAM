package madstodolist.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String s);
}
