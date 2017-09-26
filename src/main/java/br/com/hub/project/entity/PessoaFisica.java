package br.com.hub.project.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 5857404818675006065L;

	private String cpf;

	private Date dtNascimento;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
