package com.example.LmsSpringBoot.LibraryManagementSystem.Tranformers;


import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.CardStatus;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.LibraryCard;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;

import java.util.UUID;

public class LibraryTransformer {


    public static LibraryCard PrepareLibraryCarForStudent(Student student){

        return LibraryCard.builder()
                .cardStatus(CardStatus.ACTIVATED)
                .cardNo(String.valueOf(UUID.randomUUID()))
                .student(student)
                .build();

    }

}
