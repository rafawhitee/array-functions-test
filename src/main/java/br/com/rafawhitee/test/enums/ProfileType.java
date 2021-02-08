package br.com.rafawhitee.test.enums;

public enum ProfileType {
	
	Administrador("ADMIN"),
	Gerente("GERENTE"),
	Cliente("CLIENTE"),
	Vendedor("VENDEDOR");
	
	private String valor;
	
	ProfileType(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return valor;
	}

}