package br.com.hub.project.enuns;

public enum ContaStatus {
	
	A("ATIVA"), B("BLOQUEADA"), C("CANCELADA");
    
    private final String status ;
    
    ContaStatus(String opcaoValue){
    	status = opcaoValue;
    }
    
    public String getValor(){
        return status;
    }
	
}
