/**
 * 
 */
package br.com.nutribox.nbx.entity;

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
@Table(name = "tipo_pessoa")
public class TipoPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idTipoPessoa;
	private String nomeTipoPessoa;


	public TipoPessoa() {
		super();
	}


	public TipoPessoa(Short idTipoPessoa, String nomeTipoPessoa) {
		super();
		this.idTipoPessoa = idTipoPessoa;
		this.nomeTipoPessoa = nomeTipoPessoa;
	}


	public Short getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Short idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
	}

	public String getNomeTipoPessoa() {
		return nomeTipoPessoa;
	}

	public void setNomeTipoPessoa(String nomeTipoPessoa) {
		this.nomeTipoPessoa = nomeTipoPessoa;
	}
	
	

}
