package br.com.hub.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.hub.project.dto.Conta;
import br.com.hub.project.entity.ContaFilial;

@Entity
@DiscriminatorValue(value = "F")
public class ContaFilial extends Conta {
	
	@ManyToOne
    @JoinColumn(name = "conta_pai_id")
	private Conta contaPai;
	
	@OneToOne(cascade = CascadeType.ALL)
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
	 * @return the contaFilha
	 */
	public ContaFilial getContaFilha() {
		return contaFilha;
	}

	/**
	 * @param contaFilha the contaFilha to set
	 */
	public void setContaFilha(ContaFilial contaFilha) {
		this.contaFilha = contaFilha;
	}

}
