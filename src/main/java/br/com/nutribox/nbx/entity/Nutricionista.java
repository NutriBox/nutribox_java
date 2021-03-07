/**
 * 
 */
package br.com.nutribox.nbx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author edy
 *
 */
@Entity
@Table(name = "Nutricionista")
public class Nutricionista implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdNutricionista;
	private Integer CRN;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name= "NutricionistaEspecialidade",
			   joinColumns = @JoinColumn(name = "IdEspecialidade"),
			   inverseJoinColumns = @JoinColumn(name = "IdNutricionista"))
	private List<Especialidade> especialidade = new ArrayList<Especialidade>();
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;
	
	public Nutricionista() {}
	
	public Nutricionista(Integer id, Integer cRN, Pessoa pessoa) {
		this.IdNutricionista = id;
		this.CRN = cRN;
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return IdNutricionista;
	}

	public void setId(Integer id) {
		this.IdNutricionista = id;
	}

	
	public Integer getCRN() {
		return CRN;
	}	

	public void setCRN(Integer cRN) {
		CRN = cRN;
	}

	public List<Especialidade> getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(List<Especialidade> especialidade) {
		this.especialidade = especialidade;
	}
	
	

	public Integer getIdNutricionista() {
		return IdNutricionista;
	}

	public void setIdNutricionista(Integer idNutricionista) {
		IdNutricionista = idNutricionista;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdNutricionista == null) ? 0 : IdNutricionista.hashCode());
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
		Nutricionista other = (Nutricionista) obj;
		if (IdNutricionista == null) {
			if (other.IdNutricionista != null)
				return false;
		} else if (!IdNutricionista	.equals(other.IdNutricionista))
			return false;
		return true;
	}

	
}
