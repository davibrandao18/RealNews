package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class EditarController
 */
@WebServlet("/ProcessaCriacao.do")
public class ProcessaCriacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt((request.getParameter("idNoticia")));
		System.out.println(id);
		NoticiaService ns = new NoticiaService();
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		noticia.setTitulo(request.getParameter("title"));
		noticia.setDescricao(request.getParameter("description"));
		noticia.setTexto(request.getParameter("text"));
		
		if (id == 0) {
			ns.criar(noticia);
		} else {
			 ns.atualizar(noticia);
		}
		
		response.sendRedirect("./Noticias.do");
		
	}

}
