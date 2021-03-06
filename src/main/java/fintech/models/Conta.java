package fintech.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conta implements Serializable {
	
	private static final long serialVersionUID = -7020252212879848423L;

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data de criação obrigatória")
	private Date dataCriacao;
	
	private Double saldo;
	
	@NotNull(message = "A conta deve ter vinculo com pessoa")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)	
	private Pessoa pessoa;

	@Enumerated
	private SituacaoConta situacao;
	
	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST})
	@JoinTable( name = "contapai_contafilhas", 
				joinColumns = @JoinColumn( name = "fk_id_conta_pai" ), 
				inverseJoinColumns = @JoinColumn( name = "fk_id_conta_filhas" ) 
	)
	private List<Conta> contasFilhas;
	
	public Conta() {
		this.situacao = SituacaoConta.ATIVA;
		this.saldo = 0.0;
		
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}


	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}


	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	/**
	 * @return the contasFilhas
	 */
	public List<Conta> getContasFilhas() {
		return contasFilhas;
	}


	/**
	 * @param contasFilhas the contasFilhas to set
	 */
	public void setContasFilhas(List<Conta> contasFilhas) {
		this.contasFilhas = contasFilhas;
	}


	public SituacaoConta getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoConta situacao) {
		this.situacao = situacao;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return nome;
	}

}
