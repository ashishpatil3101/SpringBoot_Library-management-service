package com.example.LmsSpringBoot.LibraryManagementSystem.model;


import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    @Enumerated(EnumType.STRING)
    Genre genre;

    int noOfPages;

    double cost;

    boolean isIssued;

    @ManyToOne
    @JoinColumn
    Author author;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
