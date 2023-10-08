package com.example.LmsSpringBoot.LibraryManagementSystem.controller;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        try {
            Book result = theBookService.AddBook( theBook );
            return new ResponseEntity<>(
                    "Book added succesfully.book detail.title"+result.getTitle()+" cost "
                            +result.getCost(), HttpStatus.CREATED );
        }
        catch (Exception e) {

            return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }


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

    @GetMapping("/genre")
    public ResponseEntity getBooksByGenre( @RequestParam("TheGenre") Genre TheGenre){

        List<String > result = theBookService.getBooksByGenre( TheGenre );

        return new ResponseEntity<>( result , HttpStatus.FOUND);
    }

    @GetMapping("/genreAndPrice")
    public ResponseEntity getByGenreAndCostGreaterThen(@RequestParam("genre") String genre,@RequestParam("cost") double cost ){

        System.out.println(genre+" "+cost);
        List<BookResponseDto> result= theBookService.FindByGenreAndCostGreaterthan(genre,cost );

        return new ResponseEntity(result, HttpStatus.OK );
    }
}
