package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cargo")
    private Long id;


    @OneToMany(mappedBy = "cargo")
    private Set<CargoDiscipulo> discipulos;

    @Column(name = "str_descricao_cargo")
    private String cargo;

    public Cargo() {
    }

    public Cargo(Set<CargoDiscipulo> discipulos, String cargo) {
        this.discipulos = discipulos;
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo that = (Cargo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CargoDiscipulo> getDiscipulos() {
        return discipulos;
    }

    public void setDiscipulos(Set<CargoDiscipulo> discipulos) {
        this.discipulos = discipulos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}