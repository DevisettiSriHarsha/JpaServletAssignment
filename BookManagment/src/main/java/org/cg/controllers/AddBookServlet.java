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
import org.cg.model.Library;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImplDao dao = new ImplDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String libname = request.getParameter("library");
		Library library = dao.getLibrary(libname);
		 
		Book book = new Book();
		
		book.setLibrary(library);
		book.setBookId(Integer.parseInt(request.getParameter("bid")));
		book.setBookName(request.getParameter("bname"));
		book.setAuthor(request.getParameter("auth"));
		book.setPublisher(request.getParameter("publ"));
		
		dao.addBook(book);
		out.println("Book added");
	}

}
