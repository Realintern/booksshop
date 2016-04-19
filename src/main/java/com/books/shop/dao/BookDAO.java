package com.books.shop.dao;

import com.books.shop.model.Book;

import java.util.List;

/**
 * Created by tamarap on 4/15/16.
 */
public interface BookDAO {
    List<Book> getAllBooks();
    void addBook(Book book);
    void deleteBook(Integer id);
    void updateBook(Book book);
    public Book getBookByID(Integer id);
    List<String> getBooksName();
}
