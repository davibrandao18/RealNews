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
		int id = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		NoticiaService ns = new NoticiaService();
		Noticia noticia = ns.carregar(id);
		
		
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
						+ "<h1><a href='./Noticias.do'>RealNews</a></h1>"
						+ "<hr>"
						+ "<div class='divNoticia'>"
							+ "<h3>"+noticia.getTitulo()+"</h3>"
							+ "<p>"+noticia.getDescricao()+"</p>"
							+ "<p>"+noticia.getTexto()+"</p>"
						+ "</div>"
						+ "<hr>"
						+ "<h3 class='commentHeader'>Comentarios</h3>"
				);
						// cada noticia recebe propriedades como botao, link e descricao
						for (Comentario comentario : cs.listar(id)) {
							out.print(
									"<div class='comment'>"
										+ "<h4>" +comentario.getNome() + "</h4>"
										+ "<p>" +comentario.getTexto() + "</p>"
									+ "</div>"
							);
						}
		out.println(
				"<hr>"
						+ "<h3 class='commentHeader'>Deixe um comentario voce tambem :)</h3>"
						+ "<form class='formNewComment' action='./Comentario.do' method='post'>"
							+ "<input type='hidden' value='"+id+"' name='idNoticia'>"
							+ "<label>Nome: </label>"
							+ "<input name='nome' type='text' placeholder='Seu nome'><br>"
							+ "<label>Comentario: </label>"
							+ "<textarea name='coment' rows='5' placeholder='Escreva um comentario...'></textarea>"
							+ "<input class='formBtnSubmit' type=submit >"
						+ "</form>"
						
						+ "<form class='formEdit' action='./Editar.do' method='post'>"
							+ "<input type='hidden' value='"+id+"' name='idNoticia'>"
							+ "<button type=submit >"
								+ "<img width='30px' height='30px' src='https://www.iconsdb.com/icons/preview/white/edit-6-xxl.png'>"
							+ "</button>"
						+ "</form>"

						+ "<form class='formDelete' action='./Excluir.do' method='post'>"
							+ "<input type='hidden' value='"+id+"' name='idNoticia'>"
							+ "<button type=submit>"
								+ "<img width='30px' height='30px' src='https://www.iconsdb.com/icons/preview/white/trash-6-xxl.png'>"
							+ "</button>"
						+ "</form>"
				+"</body>"
			+ "</html>"
				);
		
	}
}