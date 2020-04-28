package service;

import java.util.ArrayList;

import dao.NoticiaDao;
import model.Noticia;

public class NoticiaService {
	
	private NoticiaDao dao = new NoticiaDao();
	
	/**
	* Metodo responsavel por chamar o inserir DAO
	* @since
	* @param Noticia noticia
	*/
	public void criar(Noticia noticia) {
		try {
			dao.inserirNoticia(noticia);
			System.out.println("Deu certo a inclusao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo responsavel por chamar o atualizar DAO
	 * @since
	 * @param Noticia noticia
	 */
	public void atualizar(Noticia noticia){
		try {
			dao.atualizarNoticia(noticia);
			System.out.println("Deu certo a atualizacao ! /n"+noticia.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo responsavel por chamar o excluir DAO
	 * @since
	 * @param int id
	 * @return 
	 */
	public void excluir(int id){
		try {
			dao.deletarNoticia(id);
			System.out.println("Deu certo a exclusao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo responsavel por chamar a consulta no DAO
	 * @since
	 * @param int id
	 * @return Noticia noticia
	 */
	public Noticia carregar(int id){
		try {
			return dao.carregarNoticia(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Metodo responsavel por listar noticias no DAO
	 * @since 0.1
	 * @param 
	 * @return ArrayList<Noticia>
	 */
	public ArrayList<Noticia> listar() {
		try {
			return dao.listarNoticias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
