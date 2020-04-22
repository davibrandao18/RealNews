package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Comentario;
import service.NoticiaService;

/**
 * 
 * @author Davi Fonseca
 *
 */
public class ComentarioDao {
	/**
	 * Metodo de insercao de Comentario no Banco de dados
	 * @param Comentario comentario
	 * @throws Exception
	 */
	public void inserirComentario(Comentario comentario) throws Exception{
		String sqlInsert = "INSERT INTO comentario"
				+"(nome, texto, fk_noticia_id)"
				+"VALUES (?,?,?)";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setString(1,comentario.getNome());
			pst.setString(2,comentario.getTexto());
			pst.setInt(3,comentario.getNoticia().getId());
			pst.execute();	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para atualizar uma Comentario no Banco de dados
	 * @param Comentario comentario
	 * @throws Exception
	 */
	public void atualizarComentario(Comentario comentario) throws Exception{
		String atualizar = "UPDATE comentario SET nome = ?, texto = ? WHERE id = '"+comentario.getId()+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(atualizar)) {
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para deletar um Comentario do Banco de dados
	 * @param int id
	 * @throws Exception
	 */
	public void deletarComentario(int id) {
		String deletar = "DELETE FROM comentario WHERE id = ?";
			
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(deletar)) {
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo de carregar um comentario.
	 * @param int id
	 * @return Comentario comentario
	 * @throws Exception
	 */
	public Comentario carregarComentario(int id) throws Exception{
		String sqlConsulta = "SELECT *"
				+"FROM comentario"
				+"WHERE id ='"+id+"'";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlConsulta);){
			
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				Comentario comentario = new Comentario();
				NoticiaService noticia = new NoticiaService();
				comentario.setId(id);
				comentario.setNome(resultado.getString("nome"));
				comentario.setTexto(resultado.getString("texto"));
				comentario.setNoticia(noticia.carregar(resultado.getInt("noticia")));
				
				return comentario;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	/**
	 * Listar Comentarios
	 * @return ArrayList<Comentario> colecaoComentarios
	 * @throws Exception
	 */
	public ArrayList<Comentario> listarComentarios() throws Exception {
		ArrayList<Comentario> colecaoComentarios = new ArrayList<>();
		String select = "SELECT * FROM comentario";
		
		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet resultado = pst.executeQuery();
		
		while(resultado.next()) {
			Comentario comentario = new Comentario();
			NoticiaService noticia = new NoticiaService();
			comentario.setId(resultado.getInt("id"));
			comentario.setNome(resultado.getString("nome"));
			comentario.setTexto(resultado.getString("texto"));
			comentario.setNoticia(noticia.carregar(resultado.getInt("noticia")));
			
			colecaoComentarios.add(comentario);
		}
			
			return colecaoComentarios;
		}
}
