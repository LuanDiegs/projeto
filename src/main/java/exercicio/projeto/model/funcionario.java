package exercicio.projeto.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = true)

@Entity
@Table(name = "funcionario")

public class funcionario {
    @Id
    @Column(name = "func_codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "ctps", nullable = false)
    private String ctps;

    @Column(name = "admissao", nullable = false)
    private Date admissao;

    @Column(name = "recisao", nullable = false)
    private Date recisao;
}
