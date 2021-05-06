package models;

public enum Perfil {
	ADM(1,"Administrador"),
	ATENDENTE(2,"Atendente");
	
	private int value;
	private String label;
	
	Perfil (int value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getLabel() {
		return label;
	}
	
}
