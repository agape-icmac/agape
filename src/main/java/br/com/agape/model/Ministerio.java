package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_ministerio")
public class Ministerio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ministerio")
    private Long id;

    @ManyToMany(mappedBy = "ministerios")
    private List<Evento> eventos;

    @Column(name = "str_descricao_mins", length = 200)
    private String descMinisterio;

    public Ministerio() {
    }

    public Ministerio(String descMinisterio) {
        this.descMinisterio = descMinisterio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ministerio that = (Ministerio) o;
        return getId().equals(that.getId());
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

    public String getDescMinisterio() {
        return descMinisterio;
    }

    public void setDescMinisterio(String descMinisterio) {
        this.descMinisterio = descMinisterio;
    }

}