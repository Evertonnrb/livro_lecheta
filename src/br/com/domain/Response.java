package br.com.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private String status;
	private String mensagem;
	
	public Response() {}
	
	public static Response Ok(String string) {
		Response r = new Response();
		r.setStatus("OK");
		r.setMensagem(string);
		return r;
	}

	public static Response Error(String string) {
		Response r = new Response();
		r.setStatus("ERROR");
		r.setMensagem(string);
		return r;
	}
	
	public String getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
