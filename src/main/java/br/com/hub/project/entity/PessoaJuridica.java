package br.com.hub.project.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = -6944933228611814572L;

	private String cnpj;

	private String razaoSocial;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
