package com.example.demo.service.impl;

import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    //Только для загрузки дефолтных элементов.
    @PostConstruct
    private void init(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"Морской волк","Джек Лондон", "1"));
        books.add(new Book(2,"Море","Джейкоб Осборн", "2"));
        books.add(new Book(3,"Переправа","Джек Вэнс", "3"));
        books.add(new Book(4,"Переводчик","Джеки Хант", "4"));
        books.add(new Book(5,"Проток","Томи Ли", "5"));
        books.add(new Book(6,"Облачный атлас","Том Моррисон", "6"));
        books.add(new Book(7,"Облететь мир","Тимати Лондон", "7"));
        books.add(new Book(8,"Облеск","Антонина Воскресенская", "8"));
        books.add(new Book(9,"Забег","Антон Чехов", "9"));
        books.add(new Book(10,"Забор","Антуан Греков", "10"));

        bookRepository.saveAll(books);
    }

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String prefix) {
        System.out.println(prefix);
        return bookRepository.findAllByAuthorStartingWith(prefix);
    }

    @Override
    public List<Book> getAllBooksByName(String prefix) {
        return bookRepository.findAllByNameStartingWith(prefix);
    }

}
