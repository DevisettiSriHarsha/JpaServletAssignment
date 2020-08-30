package org.cg.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cg.dao.ImplDao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImplDao dao = new ImplDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		dao.deleteBook(Integer.parseInt(request.getParameter("delbookid")));
		out.println("Book Deleted");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
