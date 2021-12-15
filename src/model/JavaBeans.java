package model;

public class JavaBeans {
	private String id;
	private String nome;
	private String fone;
	
	public JavaBeans(String id, String nome, String fone) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
	}	
	public JavaBeans() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
}
