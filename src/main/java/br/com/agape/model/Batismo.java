package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_batismo")
public class Batismo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_batismo")
    private Long id;

    @Column(name = "dat_batismo")
    private Date dtBatismo;

    @Column(name = "str_local_bat")
    private String localBastismo;

    @Column(name = "nome_igreja_bat")
    private String nomeIgreja;

    public Batismo() {
    }

    public Batismo(Date dtBatismo, String localBastismo, String nomeIgreja) {
        this.dtBatismo = dtBatismo;
        this.localBastismo = localBastismo;
        this.nomeIgreja = nomeIgreja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batismo batismo = (Batismo) o;
        return getId().equals(batismo.getId());
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

    public Date getDtBatismo() {
        return dtBatismo;
    }

    public void setDtBatismo(Date dtBatismo) {
        this.dtBatismo = dtBatismo;
    }

    public String getLocalBastismo() {
        return localBastismo;
    }

    public void setLocalBastismo(String localBastismo) {
        this.localBastismo = localBastismo;
    }

    public String getNomeIgreja() {
        return nomeIgreja;
    }

    public void setNomeIgreja(String nomeIgreja) {
        this.nomeIgreja = nomeIgreja;
    }
}
