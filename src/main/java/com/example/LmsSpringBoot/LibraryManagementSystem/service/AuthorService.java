package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.model.Author;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {


    AuthorRepository theAuthorRepository;

    @Autowired
    public AuthorService( AuthorRepository theAuthorRepository){

        this.theAuthorRepository = theAuthorRepository;
    }

    public String addAuthor(Author theAuthor){


        Author result = theAuthorRepository.save(theAuthor);

//        if(result.isPresent()) return result.get();

        return "author added success";
    }

}
