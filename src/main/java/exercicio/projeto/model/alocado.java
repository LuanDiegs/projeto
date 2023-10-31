package exercicio.projeto.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "alocado")

public class alocado {
    @Id
    @Column(name = "id_funcionario", nullable = false)
    private long idFuncionario;

    @Id
    @Column(name = "id_cargo", nullable = false)
    private long idCargo;

    @Column(name="aloc_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "aloc_fim", nullable = false)
    private Date dataFinal;

    @Column(name = "aloc_horas_mes", length = 200, nullable = false)
    private int horasMes;
}
