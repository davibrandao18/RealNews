package service;

import java.util.ArrayList;
import dao.ComentarioDao;
import model.Comentario;

/**
 * 
 * @author Davi Fonseca
 *
 */
public class ComentarioService {
	
	private ComentarioDao dao = new ComentarioDao();
	
	/**
	* Metodo responsavel por chamar o inserir DAO
	* @since
	* @param Comentario comentario
	*/
	public void criar(Comentario comentario) {
		try {
			dao.inserirComentario(comentario);
			System.out.println("Deu certo a inclusao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param Comentario comentario
	 */
	public void atualizar(Comentario comentario){
		try {
			dao.atualizarComentario(comentario);
			System.out.println("Deu certo a atualizacao ! /n"+comentario.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param int id
	 */
	public void excluir(int id){
		dao.deletarComentario(id);
		System.out.println("Deu certo a exclusao");
	}

	/**
	 * Metodo responsavel por chamar a consulta no DAO
	 * @since
	 * @param int id
	 * @return Comentario comentario
	 */
	public Comentario carregar(int id){
		try {
			return dao.carregarComentario(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo responsavel por chamar o listar Comentarios no DAO
	 * @since 0.1
	 * @param 
	 * @return ArrayList<Comentario>
	 */
	public ArrayList<Comentario> listar() {
		try {
			return dao.listarComentarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
