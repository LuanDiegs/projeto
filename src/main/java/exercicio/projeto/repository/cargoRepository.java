package exercicio.projeto.repository;


import exercicio.projeto.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository 
    extends JpaRepository<Cargo,Long> {
}
