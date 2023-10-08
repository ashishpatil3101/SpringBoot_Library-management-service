package com.example.LmsSpringBoot.LibraryManagementSystem.controller;

import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService theBookService;

    @Autowired
    public BookController( BookService theBookService ){

        this.theBookService = theBookService;
    }

    @PostMapping("/add")
    public ResponseEntity addBook( @RequestBody  Book theBook){

        Book result = theBookService.AddBook( theBook );

        return new ResponseEntity<>(
                "Book added succesfully.book detail.title"+result.getTitle()+" cost "
        +result.getCost(), HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public ResponseEntity  getBook(@PathVariable int id){

        Book result = theBookService.getBook( id );

        return new ResponseEntity<>(
                "title -"+result.getTitle()+" author is"+
                        result.getAuthor(),
                HttpStatus.FOUND
        );
    }
}
