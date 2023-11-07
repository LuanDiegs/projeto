package exercicio.projeto.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "TB_funcionario")

public class Funcionario {
    @Id
    @Column(name = "func_codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="nome", length = 30, nullable = false)
    private String nome;

    @Column(name = "ctps", length = 30, nullable = false)
    private String ctps;

    @Column(name = "admissao", nullable = false)
    private Date admissao;

    @Column(name = "recisao", nullable = false)
    private Date recisao;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Alocado> alocados = new HashSet<>();
}
