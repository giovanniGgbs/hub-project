package br.com.hub.project.dto;

import java.util.Date;

public class PessoaJuridica extends Pessoa {
	
	private Integer cpf;
	private Integer nomeCompleto;
	private Date dataNascimento;
	/**
	 * @return the cpf
	 */
	public Integer getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the nomeCompleto
	 */
	public Integer getNomeCompleto() {
		return nomeCompleto;
	}
	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(Integer nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
}
