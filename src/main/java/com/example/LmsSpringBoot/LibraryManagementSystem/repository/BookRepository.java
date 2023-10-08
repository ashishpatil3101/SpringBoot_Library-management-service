package com.example.LmsSpringBoot.LibraryManagementSystem.repository;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import com.example.LmsSpringBoot.LibraryManagementSystem.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

     List<Book> findByGenre(Genre genre);
}
