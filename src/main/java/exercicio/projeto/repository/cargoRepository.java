package exercicio.projeto.repository;


import exercicio.projeto.model.cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cargoRepository 
    extends JpaRepository<cargo,Long> {
}
