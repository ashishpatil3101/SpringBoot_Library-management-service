package com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults( level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    String name;

    String email;

    String message;

    String libraryCardNo;
}
