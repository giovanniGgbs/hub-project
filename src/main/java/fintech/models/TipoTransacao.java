package fintech.models;

public enum TipoTransacao {
	
	TRANSFERENCIA(0, "Transferencia"), 
	APORTE(1, "Aporte");

	private final int codigo;
	private final String descricao;
	
	private TipoTransacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
