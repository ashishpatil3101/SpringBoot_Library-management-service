package com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class issueBookResponse {

    StudentResponseDto student;

    BookResponseDto book;

    String transactionNumber;

    Date trasactionTime;
}
