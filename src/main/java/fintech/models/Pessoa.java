package fintech.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name = "tipo_pessoa", length = 2)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable{

	private static final long serialVersionUID = -873478937681752093L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id to set value of id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome to set value of nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	
}
