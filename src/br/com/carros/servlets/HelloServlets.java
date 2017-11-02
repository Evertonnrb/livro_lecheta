package br.com.carros.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("<html> <h1>Olá mundo servlet</h1> </html>");

		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String senha = req.getParameter("senha");
		resp.getWriter().print("Nome : " + nome + " Sobrenome " + sobrenome +" Senha::"+senha+ "\n\n");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().print("<html> <h1>Olá mundo servlet</h1> </html>");

		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String senha = req.getParameter("senha");
		resp.getWriter().print("Nome : " + nome + " Sobrenome " + sobrenome +" Senha::"+senha+ "\n\n");

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Chamou o put");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("Chamou o delete");
	}
}
