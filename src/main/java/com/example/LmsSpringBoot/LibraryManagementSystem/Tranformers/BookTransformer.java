package com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers;

import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.BookResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;

public class BookTransformer {

    public static BookResponseDto prpareBookResponseDtoFromBook(Book book){

        return BookResponseDto.builder()
                .cost(book.getCost())
                .title(book.getTitle())
                .genre(book.getGenre())
                .NoOfPages(book.getNoOfPages())
                .author(book.getAuthor().getName())
                .build();
    }
}
