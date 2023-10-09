package com.example.LmsSpringBoot.LibraryManagementSystem.repository;

import com.example.LmsSpringBoot.LibraryManagementSystem.model.Transaction;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
