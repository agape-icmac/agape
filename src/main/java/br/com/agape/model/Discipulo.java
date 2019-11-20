package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    private Batismo bastismo;

    @ManyToOne
    @JoinColumn(name = "cod_nacionalidade")
    private Nacionalidade nacionalidade;

    @ManyToMany
    @JoinTable(name = "tb_cargo_discipulo",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_cargo"))
    private List<CargoDiscipulo> cargos;

    @ManyToMany
    @JoinTable(name = "tb_curso_discipulo",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_curso"))
    private List<Curso> cursos;

    @ManyToMany
    @JoinTable(name = "tb_discipulo_ministerio",
            joinColumns = @JoinColumn(name = "cod_discipulo"),
            inverseJoinColumns = @JoinColumn(name = "cod_ministerio"))
    private List<Ministerio> ministerios;

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

    @Column(name = "str_curso_eclesiastico_disc")
    private String cursoEclesiastico;

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

    public Discipulo(Escolaridade escolaridade, EstadoCivil estadoCivil, Batismo bastismo, Nacionalidade nacionalidade, List<CargoDiscipulo> cargos, List<Curso> cursos, List<Evento> eventos, String nome, String nomePai, String nomeMae, String nomeConjuge, String ufNascimento, String naturalidade, char sexo, String cursoEclesiastico, String profissao, String observacao, Date dataNascimento, Long cpf, Long rg, char situacao, Long usuarioAtualizacao, Timestamp dataAtualizacao) {
        this.escolaridade = escolaridade;
        this.estadoCivil = estadoCivil;
        this.bastismo = bastismo;
        this.nacionalidade = nacionalidade;
        this.cargos = cargos;
        this.cursos = cursos;
        this.eventos = eventos;
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.nomeConjuge = nomeConjuge;
        this.ufNascimento = ufNascimento;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.cursoEclesiastico = cursoEclesiastico;
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

    public Batismo getBastismo() {
        return bastismo;
    }

    public void setBastismo(Batismo bastismo) {
        this.bastismo = bastismo;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<CargoDiscipulo> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoDiscipulo> cargos) {
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

    public String getCursoEclesiastico() {
        return cursoEclesiastico;
    }

    public void setCursoEclesiastico(String cursoEclesiastico) {
        this.cursoEclesiastico = cursoEclesiastico;
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

}