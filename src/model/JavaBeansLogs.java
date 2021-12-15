package model;

public class JavaBeansLogs {
	private String id;
	private String tipo;
	private String acao;
	
	public JavaBeansLogs(String id, String tipo, String acao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.acao = acao;
	}
	public JavaBeansLogs() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
}
