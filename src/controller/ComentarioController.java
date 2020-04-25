package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ComentarioService;
import service.NoticiaService;
import model.Comentario;
import model.Noticia;

/**
 * Servlet implementation class Comentario
 */
@WebServlet("/Comentario.do")
public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComentarioService cs = new ComentarioService();
		Comentario comentario = new Comentario();
		
		NoticiaService ns = new NoticiaService();
		Noticia noticia = new Noticia();
		String a = request.getParameter("idNoticia");
		int idNoticia = Integer.parseInt(a);
		noticia = ns.carregar(idNoticia);
		System.out.println(idNoticia+" "+(idNoticia+1) );
		
		comentario.setNome(request.getParameter("nome"));
		comentario.setTexto(request.getParameter("coment"));
		comentario.setNoticia(noticia);

		cs.criar(comentario);
		
		response.sendRedirect("./Leitura.do?id="+noticia.getId());
		
	}

}
