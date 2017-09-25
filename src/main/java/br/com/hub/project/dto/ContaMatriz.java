package br.com.hub.project.dto;

import java.util.List;

public class ContaMatriz extends Conta{
	
	private List<Conta> contasFilha;

	/**
	 * @return the contasFilha
	 */
	public List<Conta> getContasFilha() {
		return contasFilha;
	}

	/**
	 * @param contasFilha the contasFilha to set
	 */
	public void setContasFilha(List<Conta> contasFilha) {
		this.contasFilha = contasFilha;
	}
	
	
}
