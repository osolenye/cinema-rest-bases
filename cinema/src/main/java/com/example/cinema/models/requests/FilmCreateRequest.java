package com.example.cinema.models.requests;

import com.example.cinema.models.enums.Format;
import com.example.cinema.models.enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmCreateRequest {
    String name;
    String definition;
    Genre genre;
    String ageRestrictions;
    Format format;
    MultipartFile logo;
}
