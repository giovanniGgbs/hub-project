package fintech.enuns;

public enum StatusConta {

	ATIVA(0, "Ativa"), 
	BLOQUEADA(1, "Bloqueada"), 
	CANCELADA(2, "Cancelada");

	private final int codigo;
	private final String descricao;
	
	private StatusConta(int codigo, String descricao) {
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
