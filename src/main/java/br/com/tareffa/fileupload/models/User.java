package br.com.tareffa.fileupload.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "ot_usuarios")
public class User implements Serializable {

    @Id
    @Getter @Setter
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Getter @Setter
    @Column(name = "email", nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "senha", nullable = true)
    private String senha;

    @Getter @Setter
    @Column(name = "tipo", nullable = false)
    private int tipoUsuario;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "fk_contabilidades_id", referencedColumnName = "id", nullable = false)
    private Accounting contabilidade;

}
