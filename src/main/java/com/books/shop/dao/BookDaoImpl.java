package com.books.shop.dao;

import com.books.shop.model.Book;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by tamarap on 4/15/16.
 */
public class BookDaoImpl implements BookDAO {
    @Inject
    private Session session;

    public List<Book> getAllBooks() {
        return session.createQuery("from Book ").list();
    }

    public void addBook(Book book) {
        session.save(book);
    }

    public void deleteBook(Integer bookId) {
        Book book= (Book) session.get(Book.class,bookId);
        session.delete(book);
    }

    public void updateBook(Book book) {
        session.update(book);
    }
    public Book getBookByID(Integer id){
        return (Book)session.get(Book.class,id);
    }
    public List<String> getBooksName() {
        return session.createQuery("Select bookName from Book ").list();
    }

}
