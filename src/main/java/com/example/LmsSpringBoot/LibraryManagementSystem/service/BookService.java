package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Author;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class BookService {

    BookRepository theBookRepository;
    AuthorRepository theAuthorReposotory;
    @Autowired
    public  BookService( BookRepository theBookRepository, AuthorRepository theAuthorReposotory){
        this.theBookRepository = theBookRepository;
        this.theAuthorReposotory = theAuthorReposotory;
    }

    public Book AddBook(Book theBook) throws Exception {


        Optional<Author> optionalAuthor = theAuthorReposotory.findById( theBook.getAuthor().getId() );

        if( optionalAuthor.isEmpty() )
            throw new Exception("author does not exist");



        theBook.setAuthor( optionalAuthor.get());
        optionalAuthor.get().getBooks().add(theBook);

       theAuthorReposotory.save( optionalAuthor.get());
        return theBook;

    }

    public Book getBook(int id){

        Optional<Book> result = theBookRepository.findById(id );

        if(result.isPresent() )return result.get();

        return null;
    }

    public List<String> getBooksByGenre (Genre genre ){

        List<Book> booksList = theBookRepository.findByGenre( genre );

        List<String> listOftitle = new ArrayList<>();

        for( Book book : booksList) listOftitle.add( book.getTitle() );

        return listOftitle;

    }
}
