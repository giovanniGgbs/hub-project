package br.com.hub.project.dto;

import java.util.List;

public class ContaMatriz extends Conta {
	
	private List<ContaFilial> contasFilha;

	/**
	 * @return the contasFilha
	 */
	public List<ContaFilial> getContasFilha() {
		return contasFilha;
	}

	/**
	 * @param contasFilha the contasFilha to set
	 */
	public void setContasFilha(List<ContaFilial> contasFilha) {
		this.contasFilha = contasFilha;
	}
	
	
}
