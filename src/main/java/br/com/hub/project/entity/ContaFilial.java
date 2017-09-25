package br.com.hub.project.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.hub.project.dto.Conta;
import br.com.hub.project.entity.ContaFilial;

@Entity
@DiscriminatorValue(value = "F")
public class ContaFilial extends Conta {
	
	private static final long serialVersionUID = 4142793557340971806L;

	private Conta contaPai;
	
	private ContaFilial contaFilha;
	
}
