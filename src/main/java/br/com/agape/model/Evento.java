package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_evento")
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_evento")
    private Long id;

    @ManyToMany
    @JoinTable(name = "tb_evento_ministerio",
            joinColumns = @JoinColumn(name = "cod_ministerio"),
            inverseJoinColumns = @JoinColumn(name = "cod_evento"))
    private List<Ministerio> ministerios;

    @ManyToMany
    @JoinTable(name = "tb_discipulo_evento",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_evento"))
    private List<Discipulo> discipulos;

    @Column(name = "str_nome_evento")
    private String nome;

    @Column(name = "dat_inicio_evento")
    private Date dataInicio;

    @Column(name = "dat_final_evento")
    private Date dataFinal;

    @Column(name = "str_anotacao_evento")
    private String anotacao;

    public Evento() {
    }

    public Evento(List<Ministerio> ministerios, List<Discipulo> discipulos, String nome, Date dataInicio, Date dataFinal, String anotacao) {
        this.ministerios = ministerios;
        this.discipulos = discipulos;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.anotacao = anotacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return getId().equals(evento.getId());
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public List<Discipulo> getDiscipulos() {
        return discipulos;
    }

    public void setDiscipulos(List<Discipulo> discipulos) {
        this.discipulos = discipulos;
    }

    public List<Ministerio> getMinisterio() {
        return ministerios;
    }

    public void setMinisterio(List<Ministerio> ministerios) {
        this.ministerios = ministerios;
    }

}