package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import models.Carro;

public interface DAO {
	
	public boolean incluir(Carro obj);
	public boolean alterar(Carro obj);
	public boolean excluir(Integer id);
	public List<Carro> obterTodos();
	public Carro obterUm(Integer id);
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = null;
			connection = DriverManager
					.getConnection("jdbc:postgresql://127.0.0.1:5432/carrodb", "topicos1", "123456");
			return connection;
		}catch (ClassNotFoundException e) {
			System.out.println("O Driver não foi encontrado.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Falha na conexao com o banco de dados.");
			e.printStackTrace();
		}	
		return null;
	}
}
