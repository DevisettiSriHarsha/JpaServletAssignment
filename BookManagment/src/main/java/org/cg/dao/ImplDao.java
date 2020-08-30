package org.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.cg.model.Book;
import org.cg.model.Library;

public class ImplDao {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookManagment");
	private static EntityManager manager= factory.createEntityManager();
	
	public void addBook(Book book) {
		manager.getTransaction().begin();
		
		manager.persist(book);
		
		manager.getTransaction().commit();
	}
	public Library getLibrary(String libName) {
		
		TypedQuery<Library> query = manager.createQuery("SELECT l FROM Library l", Library.class);
		List<Library> libs = query.getResultList();
		
		for(Library l : libs ) {
			if(l.getLibraryName().equals(libName)) {
				return l;
			}
		}
		return null;
	}
	public Book searchBook(int bookId)
	{
		return manager.find(Book.class, bookId);
		
	}
	public Book updateBookDetails(int bookId,String bookName,String author,String publisher)
	{
		
		manager.getTransaction().begin();
		Book book = searchBook(bookId);
		if(bookName.length()!=0) {
			book.setBookName(bookName);
		}
		if(author.length()!=0) {
			book.setAuthor(author);
		}
		if(publisher.length()!=0) {
			book.setPublisher(publisher);
		}
		manager.getTransaction().commit();
		return book;
		
	}
	public void deleteBook(int bookId)
	{
		
		manager.getTransaction().begin();
		Book book = searchBook(bookId);
		manager.remove(book);
		manager.getTransaction().commit();
	}
	public List<Book> getAllBooks()
	{
		manager.getTransaction().begin();
		TypedQuery<Book>query=manager.createQuery("select * from Book b",Book.class);
		List<Book> books = query.getResultList();
		
		manager.getTransaction().commit();
		
		return books;
	}

	

}
