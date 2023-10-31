package exercicio.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "cargo")

public class Cargo {
    @Id
    @Column(name = "carg_codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="carg_nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "cli_sal_mes", nullable = false)
    private double salarioMensal;

    @Column(name = "carg_descricao", length = 200, nullable = false)
    private String descricao;
}
