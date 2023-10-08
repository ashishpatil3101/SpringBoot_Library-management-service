package com.example.LmsSpringBoot.LibraryManagementSystem.controller;

import com.example.LmsSpringBoot.LibraryManagementSystem.model.Author;
import com.example.LmsSpringBoot.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

     AuthorService theAuthorService;

    @Autowired
     public AuthorController(  AuthorService theAuthorService ){

         this.theAuthorService = theAuthorService;
     }

     @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody  Author theAuthor){

         System.out.println(theAuthor.getEmail()+" "+theAuthor.getName()+" "+theAuthor.getAge());
         String result = theAuthorService.addAuthor( theAuthor);

         return new ResponseEntity( "auhtor created succesfully" , HttpStatus.CREATED);
     }
}
