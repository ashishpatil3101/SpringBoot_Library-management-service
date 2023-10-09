package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.TransactionStatus;
import com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers.BookTransformer;
import com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers.StudentTrasnformer;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.issueBookResponse;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Transaction;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.BookRepository;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.StudentRepository;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    StudentRepository theStudentRepository;
    BookRepository theBookRepository;

    TransactionRepository theTransactionRepository;

    public TransactionService(StudentRepository theStudentRepository,BookRepository theBookRepository,TransactionRepository theTransactionRepository ){

        this.theStudentRepository = theStudentRepository;
        this.theBookRepository = theBookRepository;
        this.theTransactionRepository = theTransactionRepository;

    }

    public issueBookResponse issueAbook(int BookId, int StudentId) throws Exception {

        Optional<Student> optionalStudent = theStudentRepository.findById( StudentId);
        if(optionalStudent.isEmpty()) throw new Exception("Student not found");

        Optional<Book> optionalBook = theBookRepository.findById( BookId );
        if( optionalBook.isEmpty() )throw new Exception("Book not found");

        Book book = optionalBook.get();
        if(book.isIssued()) throw new Exception("Book has borrowed by the other student");

        Student student = optionalStudent.get();

        //create transactioon
        Transaction newTransaction = Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .book( book)
                .transactionStatus(TransactionStatus.SUCCESS)
                .libraryCard(student.getLibraryCard())
                .build();

        Transaction savedTrasaction = theTransactionRepository.save( newTransaction );

        //update the book
        book.getTransactions().add(savedTrasaction);
        book.setIssued(true);

        //labCard change
        student.getLibraryCard().getTransactions().add(savedTrasaction);

        theStudentRepository.save(student);//student  libraryacard=>libraryCard
        theBookRepository.save(book); //book and transaction

       //return
        return issueBookResponse.builder()
                .student( StudentTrasnformer.StudentToStudentResposneDto( student ))
                .book(  BookTransformer.prpareBookResponseDtoFromBook( book ))
                .transactionNumber( savedTrasaction.getTransactionNumber() )
                .trasactionTime( savedTrasaction.getTransactionTime() )
                .build();
    }

}
