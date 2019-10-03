package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_dizimo_oferta")
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_dizimo_oferta")
    private Long id;

    @ManyToOne
    private Discipulo discipulo;

    @Column(name = "num_valor_depositado_dizof")
    private BigDecimal valor;

    @Column(name = "dat_data_deposito_dizof")
    private Date data;

    @Column(name = "flg_tipo_deposito_dizof", length = 1)
    private char modalidade;

    public Receita() {
    }

    public Receita(Discipulo discipulo, BigDecimal valor, Date data, char modalidade) {
        this.discipulo = discipulo;
        this.valor = valor;
        this.data = data;
        this.modalidade = modalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return getId().equals(receita.getId());
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

    public Discipulo getDiscipulo() {
        return discipulo;
    }

    public void setDiscipulo(Discipulo discipulo) {
        this.discipulo = discipulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public char getModalidade() {
        return modalidade;
    }

    public void setModalidade(char modalidade) {
        this.modalidade = modalidade;
    }

}