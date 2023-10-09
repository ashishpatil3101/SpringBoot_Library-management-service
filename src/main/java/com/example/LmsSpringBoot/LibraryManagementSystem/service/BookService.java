package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers.BookTransformer;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Author;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
@NoArgsConstructor
public class BookService {

    BookRepository theBookRepository;
    AuthorRepository theAuthorReposotory;
    @Autowired
    public  BookService( BookRepository theBookRepository, AuthorRepository theAuthorReposotory){
        this.theBookRepository = theBookRepository;
        this.theAuthorReposotory = theAuthorReposotory;
    }

    public BookResponseDto AddBook(Book theBook) throws Exception {


        Optional<Author> optionalAuthor = theAuthorReposotory.findById( theBook.getAuthor().getId() );

        if( optionalAuthor.isEmpty() )
            throw new Exception("author does not exist");



        theBook.setAuthor( optionalAuthor.get());
        optionalAuthor.get().getBooks().add(theBook);

       theAuthorReposotory.save( optionalAuthor.get());

       BookResponseDto result = BookTransformer.prpareBookResponseDtoFromBook( theBook );
        return result;

    }

    public BookResponseDto getBook(int id){

        Optional<Book> result = theBookRepository.findById(id );

        if(result.isPresent() )return BookTransformer.prpareBookResponseDtoFromBook( result.get());

        return null;
    }

    public List<String> getBooksByGenre (Genre genre ){

        List<Book> booksList = theBookRepository.findByGenre( genre );

        List<String> listOftitle = new ArrayList<>();

        for( Book book : booksList) listOftitle.add( book.getTitle() );

        return listOftitle;

    }

    public List<BookResponseDto> FindByGenreAndCostGreaterthan(String genre, double cost){

        List<Book> responseFromRepo = theBookRepository.findByGenreAndCost( genre, cost);

        List<BookResponseDto> SendBackResponse = new ArrayList<>();

        for( Book book : responseFromRepo ){

            BookResponseDto newBookResponse= BookTransformer.prpareBookResponseDtoFromBook( book);

            SendBackResponse.add( newBookResponse );

        }

        return SendBackResponse;
    }
}
