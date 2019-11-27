package br.com.agape.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CargoDiscipuloKey implements Serializable {

    @Column(name = "cod_cargo")
    Long cargoId;

    @Column(name = "cod_discipulo")
    Long discipulo;

    public CargoDiscipuloKey() {
    }

    public CargoDiscipuloKey(Long cargoId, Long discipulo) {
        this.cargoId = cargoId;
        this.discipulo = discipulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoDiscipuloKey that = (CargoDiscipuloKey) o;

        if (getCargoId() != null ? !getCargoId().equals(that.getCargoId()) : that.getCargoId() != null) return false;
        return getDiscipulo() != null ? getDiscipulo().equals(that.getDiscipulo()) : that.getDiscipulo() == null;
    }

    @Override
    public int hashCode() {
        int result = getCargoId() != null ? getCargoId().hashCode() : 0;
        result = 31 * result + (getDiscipulo() != null ? getDiscipulo().hashCode() : 0);
        return result;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Long getDiscipulo() {
        return discipulo;
    }

    public void setDiscipulo(Long discipulo) {
        this.discipulo = discipulo;
    }
}
