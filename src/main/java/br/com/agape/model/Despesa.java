package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_despesa")
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_despesas")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_ministerio")
    private Ministerio ministerio;

    @Column(name = "num_valor_despesa")
    private BigDecimal valorDespesa;

    @Column(name = "dat_despesa")
    private Date dataDespesa;

    @Column(name = "str_descricao_despesa")
    private String descricao;

    public Despesa() {
    }

    public Despesa(Ministerio ministerio, BigDecimal valorDespesa, Date dataDespesa, String descricao) {
        this.ministerio = ministerio;
        this.valorDespesa = valorDespesa;
        this.dataDespesa = dataDespesa;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return id.equals(despesa.id);
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

    public BigDecimal getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public Date getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Ministerio getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(Ministerio ministerio) {
        this.ministerio = ministerio;
    }

}