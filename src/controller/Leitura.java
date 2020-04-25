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
 * Servlet implementation class NoticiaFull
 */
@WebServlet("/Leitura.do")
public class Leitura extends HttpServlet {
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
						+ "<title>RealNews: "+noticia.getTitulo()+"</title>"
						+ "<meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no'>"
						+ "<meta name='theme-color' content='#161819'>"
						+ "<meta name='apple-mobile-web-app-status-bar-style' content='#161819'>"
						+ "<link rel='stylesheet' href='./style.css'>"
					+ "</head>"
					+ "<body>"
						+ "<h1>RealNews</h1>"
						+ "<hr>"
						+ "<h3>"+noticia.getTitulo()+"</h3>"
						+ "<p>"+noticia.getDescricao()+"</p>"
						+ "<p>"+noticia.getTexto()+"</p>"
						+ "<hr>"
						+ "<h4>Coment�rios</h4>"
				);
						// cada noticia recebe propriedades como botao, link e descricao
						for (Comentario comentario : cs.listar()) {
							out.print(
									"<div class='cl-comentrio'>"
										+ "<p>" +comentario.getNome() + "</p>"
										+ "<p>" +comentario.getTexto() + "</p>"
									+ "</div>"
							);
						}
		out.println(
				"<hr>"
						+ "<form action='./Comentario.do' method='post'>"
							+ "<input type='hidden' value='"+id+"' name='idNoticia'>"
							+ "<label>Nome: </label><input name='nome' type='text' placeholder='Seu nome'><br>"
							+ "<label>Coment�rio: </label><input name='coment' type='textarea' placeholder='Escreva um coment�rio...'>"
							+ "<input type=submit >"
						+ "</form>"
				+"</body>"
			+ "</html>"
				);
		
	}
}