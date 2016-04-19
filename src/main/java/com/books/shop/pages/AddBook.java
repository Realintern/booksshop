package com.books.shop.pages;

import com.books.shop.dao.BookDAO;
import com.books.shop.dao.BookDaoImpl;
import com.books.shop.model.Book;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by tamarap on 4/15/16.
 */
public class AddBook {
    @Inject
    private BookDAO bookDAO;
    @Property
    private String bookName;
    @Property
    private Integer bookCount;


    @InjectComponent
    private Form add;

    @Inject
    private AlertManager alertManager;
    @Inject
    private Session session;

    @CommitAfter
    public void addBookInDB(){
        Book book=new Book();
        book.setBookCount(bookCount);
        book.setBookName(bookName);
        List<Book>books=bookDAO.getAllBooks();
        for(Book book1:books){
            if(book.getBookName().equalsIgnoreCase(book1.getBookName())){
                Book updatedBook= bookDAO.getBookByID(book1.getBookId());
                updatedBook.setBookName(book.getBookName());
                updatedBook.setBookCount(book.getBookCount());
                bookDAO.updateBook(updatedBook);
                return;
            }
        }
        bookDAO.addBook(book);
    }
    void onValidateFromAdd() {
        addBookInDB();
    }

    Object onSuccessFromAdd() {
        alertManager.success("Well!");
    return ShowAllBooks.class;
    }


}
