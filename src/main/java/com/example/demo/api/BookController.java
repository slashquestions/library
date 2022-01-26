package com.example.demo.api;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@Validated
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll(@RequestParam(value = "author", required = false) String author,
                             @RequestParam(value = "name", required = false) String name) {

        if (author == null && name != null) {
            return bookService.getAllBooksByName(name);
        } else if (author != null && name == null) {
            return bookService.getAllBooksByAuthor(author);
        } else {
            return bookService.getAllBooks();
        }
    }


}

