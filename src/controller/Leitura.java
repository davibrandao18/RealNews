package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticiaService;

/**
 * Servlet implementation class NoticiaFull
 */
@WebServlet("/Leitura.do")
public class Leitura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		NoticiaService ns = new NoticiaService();
		
		ns.carregar(Integer.parseInt(id));
		
		System.out.println(id);
	}
}
