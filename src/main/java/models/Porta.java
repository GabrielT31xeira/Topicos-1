package models;

public enum Porta {
	UMA(1,"Uma porta"),
	DUAS(2,"Duas Portas");
	
	private int value;
	private String label;
	
	Porta (int value, String label) {
		this.value = value;
		this.label = label;
	}
	public int getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}
	public static Porta valueOf(int id) {
		for (Porta porta : values()) {
			if (id == porta.getValue())
				return porta;
		}
		return null;
	}
}
