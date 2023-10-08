package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    BookRepository theBookRepository;

    @Autowired
    public  BookService( BookRepository theBookRepository){
        this.theBookRepository = theBookRepository;
    }

    public Book AddBook(Book theBook){

        Book result = theBookRepository.save( theBook);

        return result;

    }

    public Book getBook(int id){

        Optional<Book> result = theBookRepository.findById(id );

        if(result.isPresent() )return result.get();

        return null;
    }
}
