package br.com.agape.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_discipulo")
public class Discipulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_discipulo")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_nivel_escolaridade")
    private Escolaridade escolaridade;

    @ManyToOne
    @JoinColumn(name = "cod_estado_civil")
    private EstadoCivil estadoCivil;

    @ManyToOne
    @JoinColumn(name = "cod_batismo")
    private Batismo batismo;

    @ManyToOne
    @JoinColumn(name = "cod_nacionalidade")
    private Nacionalidade nacionalidade;

    @JsonProperty("collection")
    @OneToMany(mappedBy = "discipulo")
    Set<CargoDiscipulo> cargos;

    @JsonProperty("collection")
    @ManyToMany
    @JoinTable(name = "tb_curso_discipulo",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_curso"))
    @OrderColumn(name = "cod_curso_discipulo")
    private List<Curso> cursos;

    @JsonProperty("collection")
    @ManyToMany
    @JoinTable(name = "tb_discipulo_ministerio",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_ministerio"))
    private List<Ministerio> ministerios;

    @JsonProperty("collection")
    @ManyToMany(mappedBy = "discipulos")
    private List<Evento> eventos;

    @Column(name = "str_nome_completo_discipulo")
    private String nome;

    @Column(name = "str_nome_pai_disc")
    private String nomePai;

    @Column(name = "str_nome_mae_disc")
    private String nomeMae;

    @Column(name = "str_nome_conjuge_disc")
    private String nomeConjuge;

    @Column(name = "str_uf_nascimento_pes", length = 2)
    private String ufNascimento;

    @Column(name = "str_naturalidade_disc")
    private String naturalidade;

    @Column(name = "str_sexo_disc", length = 1)
    private char sexo;

    @Column(name = "str_profissao_disc")
    private String profissao;

    @Column(name = "str_obs_disc")
    private String observacao;

    @Column(name = "dat_nascimento_disc")
    private Date dataNascimento;

    @Column(name = "num_cpf_disc", length = 14)
    private Long cpf;

    @Column(name = "num_rg_disc", length = 25)
    private Long rg;

    @Column(name = "flg_situacao_disc", length = 1)
    private char situacao;

    @Column(name = "cod_usuario_atualizacao_disc")
    private Long usuarioAtualizacao;

    @Column(name = "tms_atualizacao_disc")
    private Timestamp dataAtualizacao;

    public Discipulo() {
    }

    public Discipulo(Escolaridade escolaridade, EstadoCivil estadoCivil, Batismo batismo, Nacionalidade nacionalidade, Set<CargoDiscipulo> cargos, List<Curso> cursos, List<Ministerio> ministerios, List<Evento> eventos, String nome, String nomePai, String nomeMae, String nomeConjuge, String ufNascimento, String naturalidade, char sexo, String profissao, String observacao, Date dataNascimento, Long cpf, Long rg, char situacao, Long usuarioAtualizacao, Timestamp dataAtualizacao) {
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.batismo = batismo;
        this.nacionalidade = nacionalidade;
        this.cargos = cargos;
        this.cursos = cursos;
        this.ministerios = ministerios;
        this.eventos = eventos;
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.nomeConjuge = nomeConjuge;
        this.ufNascimento = ufNascimento;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.observacao = observacao;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.situacao = situacao;
        this.usuarioAtualizacao = usuarioAtualizacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipulo discipulo = (Discipulo) o;
        return getId().equals(discipulo.getId());
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

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Batismo getBatismo() {
        return batismo;
    }

    public void setBatismo(Batismo batismo) {
        this.batismo = batismo;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<CargoDiscipulo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<CargoDiscipulo> cargos) {
        this.cargos = cargos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomeConjuge() {
        return nomeConjuge;
    }

    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    public String getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Long getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(Long usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Ministerio> getMinisterios() {
        return ministerios;
    }

    public void setMinisterios(List<Ministerio> ministerios) {
        this.ministerios = ministerios;
    }

}