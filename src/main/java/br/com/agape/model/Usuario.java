package br.com.agape.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "cpf", length = 14,unique = true)
	private String cpf;

	@Column(name = "nome_usuario", nullable = false)
	private String nome;

	@Column(name = "email_usuario", nullable = false, unique = true)
	private String email;

	@Column(name = "senha_usuario")
	private String senha;

	@Column(name = "municipio_usuario")
	private String municipio;

	@Column(name = "endereco_usuario")
	private String endereco;

	@Column(name = "cep_usuario")
	private Long cep;

	@Column(name = "telefone_usuario")
	private Long telefone;

	@ManyToOne
	@JoinColumn(name = "id_categoria_usuario", nullable = false)
	private CategoriaUsuario categoria;

	@ManyToOne
	@JoinColumn(name = "id_perfil_cliente", nullable = false)
	private PerfilCliente perfil;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Usuario() {
	}

	public Usuario(String cpf, String nome, String email, String senha, String municipio, String endereco, Long cep, Long telefone, CategoriaUsuario categoria, PerfilCliente perfil, Estado estado) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.municipio = municipio;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.categoria = categoria;
		this.perfil = perfil;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public CategoriaUsuario getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria;
	}

	public PerfilCliente getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilCliente perfil) {
		this.perfil = perfil;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}