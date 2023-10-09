package com.example.LmsSpringBoot.LibraryManagementSystem.controller;


import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.issueBookResponse;
import com.example.LmsSpringBoot.LibraryManagementSystem.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    TransactionService theTransactionService;

    public  TransactionController( TransactionService  theTransactionService){

        this.theTransactionService = theTransactionService;
    }

    @PostMapping("/issue/bookId/{bookId}/stdId/{stdId}")
    public ResponseEntity issueAbook(@PathVariable int bookId, @PathVariable int stdId){

       try {
           issueBookResponse result = theTransactionService.issueAbook( bookId ,stdId );
           return new ResponseEntity<>( result, HttpStatus.ACCEPTED );
       }
       catch (Exception e ){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }


    }
}
