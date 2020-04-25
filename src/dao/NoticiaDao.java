package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Noticia;

/**
 * Metodo de insercao de Noticia no Banco de dados
 * @author Davi Fonseca
 * @version 0.1
 * @since 0.1
 */
public class NoticiaDao {
	
	/**
	 * Metodo de insercao de Noticia no Banco de dados
	 * @param Noticia noticia
	 * @throws Exception
	 */
	public void inserirNoticia(Noticia noticia) throws Exception{
		String sqlInsert = "INSERT INTO noticia"
				+"(descricao, titulo, texto)"
				+"VALUES (?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,noticia.getDescricao());
			pst.setString(2,noticia.getTitulo());
			pst.setString(3,noticia.getTexto());
			pst.execute();	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para atualizar uma Noticia no Banco de dados
	 * @param Noticia noticia
	 * @throws Exception
	 */
	public void atualizarNoticia(Noticia noticia) throws Exception{
		String atualizar = "UPDATE noticia SET descricao = ?, titulo = ?, texto =? WHERE id = '"+noticia.getId()+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			pst.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para deletar de Noticia do Banco de dados
	 * @param int id
	 * @throws Exception
	 */
	public void deletarNoticia(int id) {
		String deletar = "DELETE FROM noticia WHERE id = ?";
			
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			pst.setInt(1, id);
			pst.execute();
			System.out.println("Dados excluidos com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo de carregar noticia.
	 * @param int id
	 * @return Noticia noticia
	 * @throws Exception
	 */
	public Noticia carregarNoticia(int id) throws Exception{
		String sqlConsulta = "SELECT * FROM noticia WHERE id ="+id;
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlConsulta);){
			
			ResultSet resultado = pst.executeQuery();

			if (resultado.next()) {
				Noticia noticia = new Noticia();
				String descricao = resultado.getString("descricao");
				String titulo = resultado.getString("titulo");
				String texto = resultado.getString("texto");
				
				noticia.setId(id);
				noticia.setDescricao(descricao);
				noticia.setTitulo(titulo);
				noticia.setTexto(texto);
				return noticia;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	/**
	 * Listar Noticias
	 * @return ArrayList<Noticia> colecaoNoticias
	 * @throws Exception
	 */
	public ArrayList<Noticia> listarNoticias() throws Exception {
		ArrayList<Noticia> colecaoNoticias = new ArrayList<>();
		String select = "SELECT * FROM noticia";
		
		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Noticia noticia = new Noticia();
			noticia.setId((resultado.getInt("id")));
			noticia.setDescricao((resultado.getString("descricao")));
			noticia.setTitulo(resultado.getString("titulo"));
			noticia.setTexto((resultado.getString("texto")));
			
			colecaoNoticias.add(noticia);
		}
			
			return colecaoNoticias;
		}
	
}
