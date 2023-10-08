package com.example.LmsSpringBoot.LibraryManagementSystem.controller;


import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.CardStatus;
import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.requestDto.StudentRequestDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.StudentResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.LibraryCard;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;
import com.example.LmsSpringBoot.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService theStudentService;

    @Autowired
    public StudentController( StudentService theStudentService ){

        this.theStudentService = theStudentService;
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody() StudentRequestDto theStudent){



        StudentResponseDto result = theStudentService.addStudent( theStudent );

        return new ResponseEntity<>( result, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity getStudent(@PathVariable int Id){

        StudentResponseDto result =  theStudentService.getStudent( Id );

        return new ResponseEntity(
                result,
                HttpStatus.FOUND
        );


    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity getStudentByEmail(@PathVariable  String mail){

        StudentResponseDto result = theStudentService.getStudentByEmail( mail );

        return new ResponseEntity("student info => "+result.getEmail()+ " name "+result.getName(), HttpStatus.FOUND );
    }

    @GetMapping("/gender")
    public List<String> getStudentByGender(@RequestParam(name="g") String g){

        System.out.println(g);
        Gender valueGender = g.equals("M") ? Gender.MALE : Gender.FEMALE;

        List<String > result = theStudentService.getAllStudentByGender( valueGender );

        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent( @PathVariable int id ){

         theStudentService.deleteAStudent( id );

        return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
    }
}
