package com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers;

import com.example.LmsSpringBoot.LibraryManagementSystem.dto.requestDto.StudentRequestDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto.StudentResponseDto;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;

public class StudentTrasnformer {

    public static Student studentREquestToStudent(StudentRequestDto studentRequestDto){

        return Student.builder()
                .age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail())
                .name(studentRequestDto.getName())
                .gender(studentRequestDto.getGender())

               .build();
    }

    public static StudentResponseDto StudentToStudentResposneDto( Student student){

        return StudentResponseDto.builder()

                .name(student.getName())
                .email(student.getEmail())
                .libraryCardNo(student.getLibraryCard().getCardNo())
                .message("your info fetched successfully")
                .build();
    }
}
