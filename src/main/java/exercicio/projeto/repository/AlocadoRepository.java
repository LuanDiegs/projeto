package exercicio.projeto.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import exercicio.projeto.model.Alocado;

public interface AlocadoRepository 
    extends JpaRepository<Alocado,Long> {
}
