package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import applications.Util;
import models.Carro;

public class CarroDAO implements DAO {

	@Override
	public boolean incluir(Carro obj) {
		Connection conn = DAO.getConnection();
		StringBuffer sql = new StringBuffer();
		boolean error = false;

		sql.append("INSERT INTO carrotb ");
		sql.append(" (marca, modelo, cor) ");
		sql.append("VALUES ");
		sql.append(" (?, ?, ?) ");

		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, obj.getMarca());
			stat.setString(2, obj.getModelo());
			stat.setString(3, obj.getCor());
//			stat.setObject(4, (obj.getAuto() == null ? null : obj.getAuto().getValue()));
//			stat.setObject(5, (obj.getPorta() == null ? null : obj.getPorta().getValue()));

			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			error = true;

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
		if (error) {
			return false;
		}
		return true;
	}

	@Override
	public boolean alterar(Carro obj) {
		Connection conn = DAO.getConnection();
		StringBuffer sql = new StringBuffer();
		boolean error = false;
		
		sql.append("UPDATE carrotb SET ");
		sql.append(" marca = ?, modelo = ?, cor = ?");
		sql.append(" WHERE ");
		sql.append(" id = ? ");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, obj.getMarca());
			stat.setString(2, obj.getModelo());
			stat.setString(3, obj.getCor());
			
			stat.setInt(4, obj.getId());
			stat.execute();
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (error)
			return false;
		return true;
	}

	@Override
	public boolean excluir(Integer id) {
		Connection conn = DAO.getConnection();
		StringBuffer sql = new StringBuffer();
		boolean error = false;
		
		sql.append("DELETE FROM carrotb WHERE id = ?");
		
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);
			stat.execute();
		} catch (Exception e) {
			e.printStackTrace();
			error = true;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (error)
			return false;
		return true;
	}

	@Override
	public List<Carro> obterTodos() {
		Connection conn = DAO.getConnection();
		List<Carro> listCarro = new ArrayList<Carro>();
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT ");
		sql.append(" c.id, ");
		sql.append(" c.marca, ");
		sql.append(" c.modelo, ");
		sql.append(" c.cor ");
//		sql.append(" c.automatico ");
//		sql.append(" c.porta ");
		sql.append("FROM ");
		sql.append(" carrotb c");

		PreparedStatement stat = null;

		try {
			stat = conn.prepareStatement(sql.toString());
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
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

		if(listCarro == null || listCarro.isEmpty()) {
			return null;
		}
		return listCarro;
	}

	@Override
	public Carro obterUm(Integer id) {
		Connection conn = DAO.getConnection();

		Carro carro = null;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append(" c.id, ");
		sql.append(" c.marca, ");
		sql.append(" c.modelo, ");
		sql.append(" c.cor ");
		sql.append("FROM ");
		sql.append("  carrotb c ");
		sql.append("WHERE ");
		sql.append("  c.id = ? ");

		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(sql.toString());
			stat.setInt(1, id);

			ResultSet rs = stat.executeQuery();

			if(rs.next()) {
				carro = new Carro();
				carro.setId(rs.getInt("id"));
				carro.setMarca(rs.getString("marca"));
				carro.setModelo(rs.getString("modelo"));
				carro.setCor(rs.getString("cor"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			carro = null;
		} finally {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return carro;
	}
}
