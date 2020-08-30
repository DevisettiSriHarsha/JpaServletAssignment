package org.cg.dao;

import java.util.List;

import org.cg.model.Book;
import org.cg.model.Library;

public interface IDao {
	
	public void addBook(Book book);
	public Library getLibrary(String libName);
	public Book searchBook(int bookId);
	public Book updateBookDetails(int id,String bname,String auth,String pub);
	public void deleteBook(int bookId);
	public List<Book> getAllBooks();
	

}
