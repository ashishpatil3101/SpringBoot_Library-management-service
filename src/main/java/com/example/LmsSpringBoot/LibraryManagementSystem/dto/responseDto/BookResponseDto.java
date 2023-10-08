package com.example.LmsSpringBoot.LibraryManagementSystem.dto.responseDto;

import com.example.LmsSpringBoot.LibraryManagementSystem.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDto {


    String title;
    Genre genre;

    String author;

    double cost;

    int NoOfPages;


}
