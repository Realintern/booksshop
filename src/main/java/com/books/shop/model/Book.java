package com.books.shop.model;

import org.apache.tapestry5.beaneditor.Validate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tamarap on 4/15/16.
 */
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    @Validate("required")
    private Integer bookId;

    @Column(name="book_name")
    @Validate("required")
    private String bookName;

    @Column(name="book_count")
    @Validate("required")
    private Integer bookCount;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
