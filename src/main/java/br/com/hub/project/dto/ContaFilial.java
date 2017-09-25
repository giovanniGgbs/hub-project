package br.com.hub.project.dto;

public class ContaFilial extends Conta{
	
	private Conta contaPai;
	
	private ContaFilial contaFilha;

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
	public ContaFilial getContasFilhas() {
		return contaFilha;
	}

	/**
	 * @param contasFilhas the contasFilhas to set
	 */
	public void setContasFilhas(ContaFilial contaFilha) {
		this.contaFilha = contaFilha;
	}
	
	
}
