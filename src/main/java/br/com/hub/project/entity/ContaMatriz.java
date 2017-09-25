package br.com.hub.project.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "M")
public class ContaMatriz extends Conta {

	private static final long serialVersionUID = 4142793557340971806L;

}
