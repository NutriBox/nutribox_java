/**
 * 
 */
package br.com.nutribox.nbx.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author edy
 *
 */
@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	private String nome;
	private String cpf;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "id_tipo_pessoa")
//	private TipoPessoa tipoPessoa;

//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;

	private Short id_tipo_pessoa;
	private Long  user_id;

	public Pessoa() {

	}

	public Pessoa(Integer idPessoa, String nome, String cpf, LocalDate dataNascimento, Short tipoPessoa) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.id_tipo_pessoa = tipoPessoa;

	}

	public Pessoa(Integer idPessoa, String nome, String cpf, LocalDate dataNascimento, Short id_tipo_pessoa, Long user) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.id_tipo_pessoa = id_tipo_pessoa;
		this.user_id = user;

	}

	public Short getIdTipoPessoa() {
		return id_tipo_pessoa;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getUserId() {
		return user_id;
	}

	public void setUser(Long user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}

}
