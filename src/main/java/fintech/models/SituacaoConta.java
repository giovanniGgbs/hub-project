package fintech.models;

public enum SituacaoConta {
	
	ATIVA(0, "Ativa"), 
	BLOQUEADA(1, "Bloqueada"), 
	CANCELADA(2, "Cancelada");

	private final int codigo;
	private final String descricao;
	
	private SituacaoConta(int codigo, String descricao) {
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
