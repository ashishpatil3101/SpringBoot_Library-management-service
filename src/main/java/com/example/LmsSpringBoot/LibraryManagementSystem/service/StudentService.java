package com.example.LmsSpringBoot.LibraryManagementSystem.service;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.CardStatus;
import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers.StudentTrasnformer;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.requestDto.StudentRequestDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.StudentResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.LibraryCard;
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
import java.util.UUID;

@Service
public class StudentService {

    StudentRepository TheStudentRepository;

    @Autowired
    public StudentService(StudentRepository paramStudentRepo){
        TheStudentRepository = paramStudentRepo;
    }

    public StudentResponseDto addStudent(StudentRequestDto theStudent){

//        Student newStudent = new Student();
//        newStudent.setAge(theStudent.getAge());
//        newStudent.setEmail(theStudent.getEmail());
//        newStudent.setName(theStudent.getName());
//        newStudent.setGender(theStudent.getGender());

        Student newStudent = StudentTrasnformer.studentREquestToStudent( theStudent);

        LibraryCard theLibraryCard= new LibraryCard();
        theLibraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        theLibraryCard.setStudent( newStudent);
        theLibraryCard.setCardStatus(CardStatus.ACTIVATED);

        newStudent.setLibraryCard(theLibraryCard);

        Student result = TheStudentRepository.save( newStudent );

        StudentResponseDto responseDtoStudent = new StudentResponseDto();
        responseDtoStudent.setEmail(result.getEmail());
        responseDtoStudent.setName(result.getName());
        responseDtoStudent.setMessage("You are record added succesfully");
        responseDtoStudent.setLibraryCardNo(theLibraryCard.getCardNo());

        return  responseDtoStudent;
    }
    public StudentResponseDto getStudent(int id){

        Optional<Student> result1 =  TheStudentRepository.findById( id );

        if(result1.isPresent() ) {

            Student result = result1.get();
            LibraryCard theLabCard= result.getLibraryCard();
//            StudentResponseDto result2 = new StudentResponseDto();
//            result2.setEmail(result.getEmail());
//            result2.setName(result.getName());
//            result2.setMessage("Your record Fetched succesfully");
//            result2.setLibraryCardNo(theLabCard.getCardNo());
            StudentResponseDto result2 = StudentTrasnformer.StudentToStudentResposneDto(result);

            return result2;
        }

        return null;
    }

    public StudentResponseDto getStudentByEmail(String mail){

        Student result =TheStudentRepository.findByEmail( mail );

        LibraryCard theLabCard= result.getLibraryCard();
//        StudentResponseDto result2 = new StudentResponseDto();
//        result2.setEmail(result.getEmail());
//        result2.setName(result.getName());
//        result2.setMessage("Your record Fetched succesfully");
//        result2.setLibraryCardNo(theLabCard.getCardNo());
        StudentResponseDto result2 = StudentTrasnformer.StudentToStudentResposneDto( result );


        return result2;


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


        return "Student deleted succesfully";
    }


}
