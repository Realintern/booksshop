package com.books.shop.pages;

import com.books.shop.dao.BookDAO;
import com.books.shop.model.Book;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tamarap on 4/15/16.
 */
public class ShowAllBooks {
    @Inject
    private BookDAO bookDAO;
    @Property
    private Book book;
    @Property
    private List<Book>  books;

    @Persist
    @Property
    private boolean  checkedBook;

    @InjectComponent
    private Form bookss;

    @InjectComponent
    private Form buyForm;




    public List<Book> createBookList(){
        return bookDAO.getAllBooks();
    }

    public void setupRender(){
        books=createBookList();

    }



    void onActionFromDelete(String id) {
        Integer idBook=Integer.parseInt(id);
        deleteUser(idBook);
    }
    @CommitAfter
    private void deleteUser(Integer id) {
        bookDAO.deleteBook(id);
    }

    Object onSuccessFromBookss() {return AddBook.class;
    }
    void onSubmitFromBuyForm(){
        List<Boolean>b =new ArrayList<Boolean>();
        b.add(checkedBook);

        if(b!=null){
            Integer x=book.getBookCount();
            }
    }
    }

