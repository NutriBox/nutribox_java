/**
 * 
 */
package br.com.nutribox.nbx.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author edy
 *
 */
@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	private String nome;
	private String cpf;
	private Instant dataNascimento;
		
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "id_tipo_pessoa")
	private TipoPessoa tipoPessoa;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Pessoa() {
		
	}
	

	public Pessoa(
			
			Integer idPessoa, 
			String nome, 
			String cpf, 
			Instant dataNascimento, 
			TipoPessoa tipoPessoa,
			User user
			) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
		this.user = user;
		
		
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public User getUser() {
		return user;
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
	
	public Instant getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
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
