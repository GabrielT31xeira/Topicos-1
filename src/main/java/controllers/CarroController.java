package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;
import applications.Util;
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
//		Connection conn = CarroController.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO carrotb ");
		sql.append(" (marca, modelo, cor) ");
		sql.append("VALUES ");
		sql.append(" (?, ?, ?) ");
		PreparedStatement stat = null;
		
		try {
//			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, getCarro().getMarca());
			stat.setString(2, getCarro().getModelo());
			stat.setString(3, getCarro().getCor());
//			stat.setObject(4, (obj.getAuto() == null ? null : obj.getAuto().getValue()));
//			stat.setObject(5, (obj.getPorta() == null ? null : obj.getPorta().getValue()));

			stat.execute();
			Util.addInfoMessage("Incluido com sucesso.");
			limpar();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
//				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	public void alterar() {
//		Connection conn = CarroController.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE carrotb SET");
		sql.append(" marca = ?, ");
		sql.append(" modelo = ?, ");
		sql.append(" cor = ? ");
		sql.append("WHERE ");
		sql.append(" id = ?");
		
		PreparedStatement stat = null;
		try {
//			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, getCarro().getMarca());
			stat.setString(2, getCarro().getModelo());
			stat.setString(3, getCarro().getCor());
			
			stat.execute();
			limpar();
			Util.addInfoMessage("Sucesso ao alterar");
		} catch (Exception e) {
			System.out.println("Erro ao realizar um comando sql de insert.");
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
//				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	public void excluir() {
		excluir(getCarro());
		limpar();
		Util.addInfoMessage("Sucesso ao excluir");
	}

	public void excluir(Carro carro) {
		listCarro.remove(carro);
		Util.addInfoMessage("Sucesso ao excluir");
	}

	public void limpar() {
		setCarro(null);
		setListCarro(null);
	}

	public void editar(Carro carro) {
		setCarro(carro.getClone());
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
			listCarro = new ArrayList<Carro>();
//			Connection conn = CarroController.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(" c.id, ");
			sql.append(" c.marca, ");
			sql.append(" c.modelo, ");
			sql.append(" c.cor ");
//			sql.append(" c.automatico ");
//			sql.append(" c.porta ");
			sql.append("FROM ");
			sql.append(" carrotb c");

			PreparedStatement stat = null;

			try {
//				stat = conn.prepareStatement(sql.toString());
				ResultSet rs = stat.executeQuery();	
				while(rs.next()) {
					Carro carro = new Carro();
					carro.setId(rs.getInt("id"));
					carro.setMarca(rs.getString("marca"));
					carro.setModelo(rs.getString("modelo"));
					carro.setCor(rs.getString("cor"));
//					carro.setAuto(Automatico.valueOf(rs.getInt("automatico")));
//					carro.setPorta(Porta.valueOf(rs.getInt("porta")));

					listCarro.add(carro);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stat.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
//					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listCarro;
	}

	public void setListCarro(List<Carro> listCarro) {
		this.listCarro = listCarro;
	}
}
