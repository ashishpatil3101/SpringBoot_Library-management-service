package com.example.LmsSpringBoot.LibraryManagementSystem.dto.requestDto;

import ch.qos.logback.core.joran.spi.DefaultClass;
import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults( level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    Gender gender;

    int age;

    String email;

    String name;
}
