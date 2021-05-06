package models;

import java.time.LocalDate;
import java.util.List;

public class Funcionario implements Cloneable{

	private Integer id;
	private LocalDate dataCadastro;
	private String cpf;
	private String senha;
	private Boolean ativo;
	private Perfil perfil;
	
	public Funcionario() {};
	public Funcionario(Integer id, LocalDate dataCadastro, String cpf, String senha, Boolean ativo, Perfil perfil) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.cpf = cpf;
		this.senha = senha;
		this.ativo = ativo;
		this.perfil = perfil;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Funcionario getClone() {
		try {
			return (Funcionario) super.clone();
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", dataCadastro=" + dataCadastro + ", cpf=" + cpf + ", senha=" + senha
				+ ", ativo=" + ativo + ", perfil=" + perfil + "]";
	}
	
}
