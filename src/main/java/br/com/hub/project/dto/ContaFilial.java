package br.com.hub.project.dto;

import java.util.List;

public class ContaFilial extends Conta{
	
	private Conta contaPai;
	private List<Conta> contasFilhas;

	/**
	 * @return the contaPai
	 */
	public Conta getContaPai() {
		return contaPai;
	}

	/**
	 * @param contaPai the contaPai to set
	 */
	public void setContaPai(Conta contaPai) {
		this.contaPai = contaPai;
	}

	/**
	 * @return the contasFilhas
	 */
	public List<Conta> getContasFilhas() {
		return contasFilhas;
	}

	/**
	 * @param contasFilhas the contasFilhas to set
	 */
	public void setContasFilhas(List<Conta> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}
	
	
}
