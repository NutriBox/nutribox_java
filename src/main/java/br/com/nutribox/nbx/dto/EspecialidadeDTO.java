/**
 * 
 */
package br.com.nutribox.nbx.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.nutribox.nbx.entity.Especialidade;

/**
 * @author edy
 *
 */
public class EspecialidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idEspecialidade;
			
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nomeEspecialidade;
	
	public EspecialidadeDTO() {
		
	}
	
	public EspecialidadeDTO( Especialidade obj ) {
		idEspecialidade = obj.getIdEspecialidade();
		nomeEspecialidade = obj.getNomeEspecialidade();
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


}
