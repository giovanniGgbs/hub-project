package br.com.hub.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "M")
public class ContaMatriz extends Conta {
	
	public void setContaFilha(List<ContaFilial> contaFilha) {
		this.contaFilha = contaFilha;
	}

	private static final long serialVersionUID = 4142793557340971806L;
	
	@OneToMany(mappedBy = "contaPai", cascade = CascadeType.ALL)
	private List<ContaFilial> contaFilha; 
	
	/**
	 * @return the contaFilha
	 */
	public List<ContaFilial> getContaFilha() {
		return contaFilha;
	}

	/**
	 * @param contaFilha the contaFilha to set
	 */
	

}
