package br.com.cantarino.Models;

public class Response {
	
	
	private int codigo;	
	private String mensagem;

	


	
	public  Response() {}

	public Response(int codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMensagem() {
		return mensagem;
	}

	
	
	
	
}
