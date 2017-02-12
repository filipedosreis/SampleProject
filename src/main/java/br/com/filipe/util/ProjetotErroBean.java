package br.com.filipe.util;

/**
 * Created by filipedosreis@gmail.com on 09/02/2017.
 */
public class ProjetotErroBean {
	
	private Integer codigo;
	private String mensagem;
	
	public ProjetotErroBean(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


}
