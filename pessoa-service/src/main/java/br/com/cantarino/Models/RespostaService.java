package br.com.cantarino.Models;

public enum RespostaService {

	ERRO(0), OK(1) ;
	
	private final int valor;	
	private RespostaService(int value)
	{
		this.valor = value;
	}
	
	public int getValor() {
		return valor;
	}
	
	
			
}
