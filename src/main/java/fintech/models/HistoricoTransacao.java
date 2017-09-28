package fintech.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoTransacao implements Serializable {

	private static final long serialVersionUID = 1788348013547252197L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;

	@Column(nullable = false)
	private Date data;
	
	@ManyToOne(optional = false)
	private Conta conta;
	
	private String codigoAporte;
	
	private Double valorTransferencia;
	
	@Enumerated
	private TipoTransacao tipoTransacao;

	public HistoricoTransacao() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getCodigoAporte() {
		return codigoAporte;
	}

	public void setCodigoAporte(String codigoAporte) {
		this.codigoAporte = codigoAporte;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	@Override
	public String toString() {
		return descricao + " - " + new SimpleDateFormat("dd-MM-yyyy").format(data);
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
}
