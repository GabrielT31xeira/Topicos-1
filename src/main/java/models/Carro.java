package models;

import java.time.LocalDate;

public class Carro implements Cloneable{

	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private LocalDate ano;
	private Automatico auto;
	private Porta porta;
	
	public Carro() {}

	public Carro(Integer id, String marca, String modelo, String cor, LocalDate ano, Automatico auto, Porta porta) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.auto = auto;
		this.porta = porta;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public LocalDate getAno() {
		return ano;
	}
	public void setAno(LocalDate ano) {
		this.ano = ano;
	}
	public Automatico getAuto() {
		return auto;
	}
	public void setAuto(Automatico auto) {
		this.auto = auto;
	}
	public Porta getPorta() {
		return porta;
	}
	public void setPorta(Porta porta) {
		this.porta = porta;
	}
	public Carro getClone() {
		try {
			return (Carro) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", ano=" + ano
				+ ", auto=" + auto + ", porta=" + porta + "]";
	}
	
}
