package com.example.LmsSpringBoot.LibraryManagementSystem.model;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "student_info")
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

    @Column(name="first_name")
    String name;

    int age;

    @Column(unique = true,nullable = false)
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard libraryCard;
}
