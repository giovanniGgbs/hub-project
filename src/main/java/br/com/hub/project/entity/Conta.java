package br.com.hub.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = -7020252212879848423L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotNull(message = "Data de criação obrigatória")
	private Date dataCriacao;

	@NotNull(message = "A conta deve ter vinculo com pessoa")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)	
	private Pessoa pessoa;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinTable( name = "contapai_contafilhas", 
				joinColumns = @JoinColumn( name = "fk_id_conta_pai" ), 
				inverseJoinColumns = @JoinColumn( name = "fk_id_conta_filhas" ) 
	)
	private List<Conta> contasFilhas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return nome;
	}
}
