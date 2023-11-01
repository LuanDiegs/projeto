package exercicio.projeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import exercicio.projeto.model.Funcionario;

public interface FuncionarioRepository 
    extends JpaRepository<Funcionario,Long> {
}
