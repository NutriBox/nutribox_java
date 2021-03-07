/**
 * 
 */
package br.com.nutribox.nbx.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author edy
 *
 */
@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	private String logradouro; 
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private Integer ibge;
	private Integer gia;
	private Short ddd;
	private Integer siafi;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer idEndereco, String logradouro, String complemento, String bairro, String localidade, String uf,
			Integer ibge, Integer gia, Short ddd, Integer siafi, Pessoa pessoa) {
		super();
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.ibge = ibge;
		this.gia = gia;
		this.ddd = ddd;
		this.siafi = siafi;
		this.pessoa = pessoa;
	}



	public Integer getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getLocalidade() {
		return localidade;
	}


	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public Integer getIbge() {
		return ibge;
	}


	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}


	public Integer getGia() {
		return gia;
	}


	public void setGia(Integer gia) {
		this.gia = gia;
	}


	public Short getDdd() {
		return ddd;
	}


	public void setDdd(Short ddd) {
		this.ddd = ddd;
	}


	public Integer getSiafi() {
		return siafi;
	}


	public void setSiafi(Integer siafi) {
		this.siafi = siafi;
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
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
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
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
	
	
}
