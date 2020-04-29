package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Criar
 */
@WebServlet("/Criar.do")
public class Criar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
	 
		// Set response content type
		response.setContentType("text/html");
		
		out.println(
				"<html> "
					+"<head> "
						+ "<title>RealNews: Criar Noticia</title>"
						+ "<meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no'>"
						+ "<meta name='theme-color' content='#161819'>"
						+ "<meta name='apple-mobile-web-app-status-bar-style' content='#161819'>"
						+ "<link rel='stylesheet' href='./style.css'>"
						+ "<link rel='shortcut icon' href='/JornalRealNews/img/realnews.png'"
					+ "</head>"
					+ "<body>"
						+ "<h1><img src='/JornalRealNews/img/realnews.png'  width='30px' height='30px'>"
						+ "<a href='./Noticias.do'>RealNews</a></h1>"
						+ "<hr>"
						+ "<h3 class='EditHeader'>Criar noticia</h3>"
						+ "<form class='formEdit' action='./ProcessaCriacao.do' method='post'>"
							+ "<input type='hidden' value='0' name='idNoticia'>"
							+ "<input type='text' name='title' placeholder='Adicione um titulo'>"
							+ "<textarea name='description' rows='5' placeholder='Escreva uma descricao...'></textarea>"
							+ "<textarea name='text' rows='5' placeholder='Escreva o texto...'></textarea>"
							+ "<button type=submit>"
								+ "<img width='30px' height='30px' src='/JornalRealNews/img/right.png'>"
							+ "</button>"
						+ "</form>"
					+"</body>"
				+ "</html>"
				);
		
	}

}
