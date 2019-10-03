package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_meta_ministerial")
public class MetaMinisterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_meta_ministerial")
    private Long id;

    @Column(name = "cod_meta_ministerial")
    private String meta;

    @Column(name = "dat_inicio_meta")
    private Date dataInicio;

    @Column(name = "dat_final_meta")
    private Date dataFinal;

    @ManyToOne
    private Ministerio ministerio;

    @Column(name = "flg_meta_alcancada", length = 1)
    private char metaAlcancada;

    public MetaMinisterial() {
    }

    public MetaMinisterial(String meta, Date dataInicio, Date dataFinal, Ministerio ministerio, char metaAlcancada) {
        this.meta = meta;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.ministerio = ministerio;
        this.metaAlcancada = metaAlcancada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaMinisterial that = (MetaMinisterial) o;
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

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Ministerio getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

    public char getMetaAlcancada() {
        return metaAlcancada;
    }

    public void setMetaAlcancada(char metaAlcancada) {
        this.metaAlcancada = metaAlcancada;
    }

}