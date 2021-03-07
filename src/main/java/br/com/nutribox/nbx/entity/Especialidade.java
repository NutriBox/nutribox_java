/**
 * 
 */
package br.com.nutribox.nbx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author edy
 *
 */
@Entity
@Table(name = "Especialidade")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidade;	
	private String nomeEspecialidade;

		
	public Especialidade(){}
	
	public Especialidade(Integer idEspecialidade, String nomeEspecialidade) {
		this.idEspecialidade = idEspecialidade;
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public Integer getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Integer idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEspecialidade == null) ? 0 : idEspecialidade.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (idEspecialidade == null) {
			if (other.idEspecialidade != null)
				return false;
		} else if (!idEspecialidade.equals(other.idEspecialidade))
			return false;
		return true;
	}

	
	
}
