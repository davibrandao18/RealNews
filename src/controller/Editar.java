package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class Comentario
 */
@WebServlet("/Editar.do")
public class Editar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		NoticiaService ns = new NoticiaService();
		Noticia noticia = ns.carregar(Integer.parseInt(id));
		
		
		ComentarioService cs = new ComentarioService();
		// Set refresh, autoload time as 5 seconds
		response.setIntHeader("Refresh", 60);
	 
		// Set response content type
		response.setContentType("text/html");
		
		out.println(
				"<html> "
						+"<head> "
						+ "<title>RealNews: editar "+noticia.getTitulo()+"</title>"
						+ "<meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no'>"
						+ "<meta name='theme-color' content='#161819'>"
						+ "<meta name='apple-mobile-web-app-status-bar-style' content='#161819'>"
						+ "<link rel='stylesheet' href='./style.css'>"
					+ "</head>"
					+ "<body>"
						+ "<h1><a href='./Noticias.do'>RealNews</a></h1>"
						+ "<hr>"
						+ "<h3 class='commentHeader'>Comentários</h3>"
						+ "<form class='formEdit' action='./Editar.do' method='post'>"
							+ "<input type='hidden' value='"+id+"' name='idNoticia'>"
							+ "<button type=submit >"
								+ "<img width='30px' height='30px' src='https://www.iconsdb.com/icons/preview/white/check-mark-12-xxl.png'>"
							+ "</button>"
						+ "</form>"
				+"</body>"
			+ "</html>"
				);
		
	}
}