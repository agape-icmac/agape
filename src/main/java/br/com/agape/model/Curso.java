package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_curso")
    private Long id;

    @ManyToMany(mappedBy = "cursos")
    private List<Discipulo> discipulos;

    @Column(name = "str_nome_curso")
    private String nome;

    @Column(name = "str_dsc_curso")
    private String descricao;

    public Curso() {
    }

    public Curso(List<Discipulo> discipulos, String nome, String descricao) {
        this.discipulos = discipulos;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return getId().equals(curso.getId());
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Discipulo> getDiscipulos() {
        return discipulos;
    }

    public void setDiscipulos(List<Discipulo> discipulos) {
        this.discipulos = discipulos;
    }

}