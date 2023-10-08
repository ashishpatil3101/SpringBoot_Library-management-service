package com.example.LmsSpringBoot.LibraryManagementSystem.repository;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String mail);

    List<Student> findByGender(Gender gender);

}
