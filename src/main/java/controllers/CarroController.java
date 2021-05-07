package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;
import applications.Util;
import dao.CarroDAO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import models.Automatico;
import models.Carro;
import models.Porta;

@Named
@ApplicationScoped
public class CarroController implements Serializable {
	private static final long serialVersionUID = 2815736461208953545L;
	private Carro carro = null;
	private List<Carro> listCarro;
	private int count = 0;

	public void incluir() {
		CarroDAO dao = new CarroDAO();
		if (dao.incluir(getCarro())) {
			Util.addInfoMessage("Incluido com sucesso.");
			limpar();
		} else {
			Util.addErrorMessage("Deu ruim");
		}
	}

	public void alterar() {
		CarroDAO dao = new CarroDAO();
		if (dao.alterar(getCarro())) {
			Util.addInfoMessage("Alterado com sucesso.");
			limpar();
		} else {
			Util.addErrorMessage("Deu ruim");
		}
	}

	public void excluir() {
		excluir(getCarro());
		limpar();
		Util.addInfoMessage("Sucesso ao excluir");
	}

	public void excluir(Carro carro) {
		CarroDAO dao = new CarroDAO();
		dao.excluir(carro.getId());
		limpar();
	}

	public void limpar() {
		setCarro(null);
		setListCarro(null);
	}

	public void editar(Carro carro) {
		CarroDAO dao = new CarroDAO();
		setCarro(dao.obterUm(carro.getId()));
	}

	public Automatico[] getListaAutomatico() {
		return Automatico.values();
	}

	public Porta[] getListaPorta() {
		return Porta.values();
	}

	public Carro getCarro() {
		if (carro == null) {
			carro = new Carro();
		}
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getListCarro() {
		if (listCarro == null) {
			CarroDAO dao = new CarroDAO();
			listCarro = dao.obterTodos();
			if (listCarro == null) {
				listCarro = new ArrayList<Carro>();
			}
		}
		return listCarro;

	}

	public void setListCarro(List<Carro> listCarro) {
		this.listCarro = listCarro;
	}
}
