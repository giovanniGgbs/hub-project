package fintech.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 5857404818675006065L;

	private String cpf;

	private Date dtNascimento;

	/**
	 * @return cpf value
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf to set value without format
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf.replace(".", "").replace("-", "");
	}

	/**
	 * @return dtNascimento value
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", dtNascimento=" + dtNascimento + "]";
	}
	

}
