package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(String prefix);

    List<Book> getAllBooksByName(String prefix);

}
