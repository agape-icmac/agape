package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_discipulo")
public class Discipulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_discipulo")
    private Long id;

    private Escolaridade scolaridade;

    private EstadoCivil estadoCivil;

}
