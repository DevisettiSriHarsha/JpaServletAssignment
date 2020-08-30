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
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ImplDao dao = new ImplDao();
		
		int bookId = Integer.parseInt(request.getParameter("updatebId"));
		Book book=dao.searchBook(bookId);

		String updatedBookName = request.getParameter("updateBName");
		String updatedAuth = request.getParameter("updateAuth");
		String updatedPub = request.getParameter("updatePub");

		out.println("<html>");
		out.println("<body>");

		out.println("Before Update");
		out.print("<br>");
		out.print("<br>");
		out.println("Book Name : " + book.getBookName());
		out.print("<br>");
		out.println("Book Author : " + book.getAuthor());
		out.print("<br>");
		out.println("Book Publisher Name : " + book.getPublisher());
		out.print("<br>");
		Book updateBook = dao.updateBookDetails(bookId, updatedBookName, updatedAuth, updatedPub);
		out.println("Book Name : " + updateBook.getBookName());
		out.print("<br>");
		out.println("Book Author : " + updateBook.getAuthor());
		out.print("<br>");
		out.println("Book Publisher Name : " + updateBook.getPublisher());
		out.print("<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
