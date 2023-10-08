package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;
import com.example.LmsSpringBoot.LibraryManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository TheStudentRepository;

    @Autowired
    public StudentService(StudentRepository paramStudentRepo){
        TheStudentRepository = paramStudentRepo;
    }

    public Student addStudent(Student paraStudent){

        Student result = TheStudentRepository.save( paraStudent );

        return  result;
    }
    public Student getStudent(int id){

        Optional<Student> result =  TheStudentRepository.findById( id );

        if(result.isPresent() )return result.get();

        return null;
    }

    public Student getStudentByEmail(String mail){

        Student result =TheStudentRepository.findByEmail( mail );

        return result;
    }

    public List<String> getAllStudentByGender(Gender gender){

        List<Student> list= TheStudentRepository.findByGender( gender );

        List<String > names = new ArrayList<>();

        for( Student std : list){
            names.add( std.getName() );
        }

        return names;
    }

    public String deleteAStudent(int id){

         TheStudentRepository.deleteById( id);


        return "Student delete succesfully";
    }


}
