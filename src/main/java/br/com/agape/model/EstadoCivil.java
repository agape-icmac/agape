package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_estado_civil")
public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_estado_civil")
    private Long id;

    @Column(name = "str_descricao_estciv")
    private String estadoCivilDesc;

    public EstadoCivil() {
    }

    public EstadoCivil(String estadoCivilDesc) {
        this.estadoCivilDesc = estadoCivilDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoCivil that = (EstadoCivil) o;
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

    public String getEstadoCivilDesc() {
        return estadoCivilDesc;
    }

    public void setEstadoCivilDesc(String estadoCivilDesc) {
        this.estadoCivilDesc = estadoCivilDesc;
    }

}