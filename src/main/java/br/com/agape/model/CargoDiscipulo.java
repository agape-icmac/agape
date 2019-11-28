//https://www.baeldung.com/jpa-many-to-many
package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_cargo_discipulo")
public class CargoDiscipulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cargo_discipulo")
    Long id;

    @ManyToOne
    @JoinColumn(name = "cod_cargo")
    Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "cod_discipulo")
    Discipulo discipulo;

    public CargoDiscipulo() {
    }

    public CargoDiscipulo(Cargo cargo, Discipulo discipulo) {
        this.cargo = cargo;
        this.discipulo = discipulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoDiscipulo that = (CargoDiscipulo) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Discipulo getDiscipulo() {
        return discipulo;
    }

    public void setDiscipulo(Discipulo discipulo) {
        this.discipulo = discipulo;
    }
}
