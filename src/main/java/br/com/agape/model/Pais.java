package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pais")
    private Long id;

    @Column(name = "str_nome_pais")
    private String pais;

    @Column(name = "str_sigla_pais")
    private String sigla;

    @Column(name = "num_ddi_pais", length = 2)
    private Integer ddi;

    public Pais() {
    }

    public Pais(String pais, String sigla, Integer ddi) {
        this.pais = pais;
        this.sigla = sigla;
        this.ddi = ddi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return getId().equals(pais.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

}