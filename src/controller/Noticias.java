package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet para geração do mural de notícias
 * @author Maicon Souza
 * @since
 */
@WebServlet("/Noticias.do")
public class Noticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		NoticiaService ns = new NoticiaService();
		
		
		// Cabecalho, titulo da aplicacao e linha horizontal
		out.println(
					"<html> "
							+"<head> "
							+ "<title>RealNews: inicio</title>"
							+ "<meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no'>"
							+ "<meta name='theme-color' content='#161819'>"
							+ "<meta name='apple-mobile-web-app-status-bar-style' content='#161819'>"
							+ "<link rel='stylesheet' href='./style.css'>"
						+ "</head>"
						+ "<body>"
							+ "<h1>RealNews</h1>"
							+ "<hr>"
					);
		
		
		// cada noticia recebe propriedades como botao, link e descricao
		for (Noticia noticia : ns.listar()) {
			out.print(
					"<button class='btn-noticia'>"
						+ "<a href='./Leitura.do?id=" +noticia.getId() +"'>" + noticia.getTitulo() +"</a>"
						+ "<p>" +noticia.getDescricao() +"</p>"
					+ "</button>"
			);
		}
		
		
		// fechamento de tags restantes
		out.println("</body>"
				+ "</html>");
	}
}
