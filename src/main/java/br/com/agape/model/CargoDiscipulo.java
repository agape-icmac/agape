package br.com.agape.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_cargo_discipulo")
public class CargoDiscipulo {

    @EmbeddedId
    @Column(name = "cod_cargo_discipulo")
    CargoDiscipuloKey id;

    @ManyToOne
    @MapsId("cod_cargo")
    @JoinColumn(name = "cod_cargo")
    Cargo cargo;

    @ManyToOne
    @MapsId("cod_discipulo")
    @JoinColumn(name = "cod_discipulo")
    Discipulo discipulo;

    public CargoDiscipulo() {
    }

    public CargoDiscipulo(CargoDiscipuloKey id, Cargo cargo, Discipulo discipulo) {
        this.id = id;
        this.cargo = cargo;
        this.discipulo = discipulo;
    }

    public CargoDiscipuloKey getId() {
        return id;
    }

    public void setId(CargoDiscipuloKey id) {
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
