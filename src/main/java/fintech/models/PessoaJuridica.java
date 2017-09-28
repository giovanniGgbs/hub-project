package fintech.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = -6944933228611814572L;

	private String cnpj;

	private String razaoSocial;
	

	/** 
	 * @return cnpj value
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj to set value without format
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
	}

	/**
	 * @return razaoSocial value
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial to set value
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}
	
	

}
