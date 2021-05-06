package models;

public enum Automatico {
	AUTOMATICO(1,"Automatico"),
	SEMIAUTOMATICO(2,"Semi-Automatico");
	
	private int value;
	private String label;
	
	Automatico (int value, String label) {
		this.value = value;
		this.label = label;
	}
	public int getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
	public static Automatico valueOf(int id) {
		for (Automatico automatico : values()) {
			if (id == automatico.getValue())
				return automatico;
		}
		return null;
	}

}
