package br.com.nutribox.nbx.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.nutribox.nbx.entity.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idPessoa;
	private String nome;
	private String cpf;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	private Short id_tipo_pessoa;
	private Long idUser;	

	public PessoaDTO(Pessoa obj) {
		idPessoa = obj.getIdPessoa();
		nome = obj.getNome();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		id_tipo_pessoa = obj.getIdTipoPessoa();
		idUser = obj.getUserId();
	}

	public PessoaDTO() {
	}

	public PessoaDTO(Integer idPessoa, String nome, String cpf, LocalDate dataNascimento, Short tipoPessoa,
			Long idUser) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.id_tipo_pessoa = tipoPessoa;
		this.idUser = idUser;

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

	public Short getIdTipoPessoa() {
		return id_tipo_pessoa;
	}

	public void setIdTipoPessoa(Short tipoPessoa) {
		this.id_tipo_pessoa = tipoPessoa;
	}

	public Long getIdUser() {	
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


}
