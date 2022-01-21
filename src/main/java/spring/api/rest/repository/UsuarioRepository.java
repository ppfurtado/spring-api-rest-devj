package spring.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.api.rest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
