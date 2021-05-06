package controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class MenuController implements Serializable{
	private static final long serialVersionUID = 4733675950255493360L;
	public void login() throws IOException {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml"); 
	}
	public void crud() throws IOException {
		System.out.println("Redireciona");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath() + "/faces/crud.xhtml"); 
}

}
