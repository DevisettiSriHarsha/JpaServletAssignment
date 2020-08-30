package org.cg.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cg.dao.ImplDao;
import org.cg.model.Book;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ImplDao dao = new ImplDao();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Book book = dao.searchBook(Integer.parseInt(request.getParameter("getbid")));
		if(book!=null)
		{
			out.println("Book Id : "+book.getBookId());
			out.println("Book Name : "+book.getBookName());
			out.println("Author of Book : "+book.getAuthor());
			out.println("Publisher of Book : "+book.getPublisher());
		}
		else {
			out.println("enter valid book");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
