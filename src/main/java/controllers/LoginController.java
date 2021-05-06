package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import models.Funcionario;
import models.Perfil;

@Named
@RequestScoped
public class LoginController  implements Serializable{
	private static final long serialVersionUID = 7929357021320392268L;
	private Funcionario funcionario;
	private List<Funcionario> listFunc;
	private int count = 0;
	
	public void logar() throws IOException {
		if(funcionario.getCpf().equals("456.456.456-56") && funcionario.getSenha().equals("12345")) {
			System.out.println("Redireciona");
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/faces/menu.xhtml"); 
		}
		
	}
	public Perfil[] getListaAuto() {
		return Perfil.values();
	}	
	public Funcionario getFuncionario() {
		if(funcionario == null) {
			funcionario = new Funcionario();
		}

		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getListFunc() {
		if (listFunc == null) {
			listFunc = new ArrayList<Funcionario>();
			if(count == 0) {
				listFunc.add(new Funcionario(1,LocalDate.now(),"123.321.123-23","12345",true,Perfil.ADM));
				listFunc.add(new Funcionario(2,LocalDate.now(),"321.312.321-21","54321",true,Perfil.ADM));
				listFunc.add(new Funcionario(3,LocalDate.now(),"456.654.456-54","23412",true,Perfil.ATENDENTE));
				listFunc.add(new Funcionario(4,LocalDate.now(),"554.654.456-65","54231",false,Perfil.ADM));
				listFunc.add(new Funcionario(5,LocalDate.now(),"654.654.456-45","34215",false,Perfil.ADM));
				listFunc.add(new Funcionario(6,LocalDate.now(),"789.789.987-09","43234",false,Perfil.ADM));
				count = 6;
			}
		}
		return listFunc;
	}
	public void setListFunc(List<Funcionario> listFunc) {
		this.listFunc = listFunc;
	}
	
}
