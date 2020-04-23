package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
	
	//O metodo statico a seguir tem como funcao encontrar o driver do mysql
		static {
			try {
				System.out.println("Procurando driver..");
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				System.out.println("Drive encontrado !");
			} catch (ClassNotFoundException e) {
				
				System.out.println("Driver NAO encontrado...");
				
				throw new RuntimeException(e);
			}
		}
		
		// Obtem conexao com o banco de dados
		public static Connection obtemConexao() throws SQLException {
			try {
				return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/portal_realnews?useTimezone=true&serverTimezone=America/Sao_Paulo"
							+ "&user=master&password=*Quiki18@");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "NAO foi estabelecida conexao !");
					throw new RuntimeException(e);
				}
		}
}
