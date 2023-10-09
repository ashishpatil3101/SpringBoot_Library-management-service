package com.example.LmsSpringBoot.LibraryManagementSystem.model;


import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transaction {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;


    String transactionNumber;

    @CreationTimestamp
    Date transactionTime;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;
}
