package exercicio.projeto.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "alocado")
public class Alocado {

    @Id
    @Column(name = "id_alocacao", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="aloc_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "aloc_fim", nullable = false)
    private Date dataFinal;

    @Column(name = "aloc_horas_mes", length = 200, nullable = false)
    private int horasMes;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
}
