package com.example.cinema.models.responses;

import com.example.cinema.models.enums.Language;
import com.example.cinema.utils.ResourceBundle;
import lombok.*;
import lombok.experimental.FieldDefaults;



@Builder
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Response<D>{
    String mess;
    D data;
    public static <D> Response<D> getSuccessResponse(D responseData, Language lang) {
        return Response
                .<D>builder()
                .mess(ResourceBundle.periodMess("successResponse", lang))
                .data(responseData)
                .build();
    }

    public static <D> Response<D> getUniqueFieldResponse(String key, Language lang) {
        return Response
                .<D>builder()
                .mess(ResourceBundle.periodMess(key, lang))
                .build();
    }

    public static <D> Response<D> getErrorResponse(String key, Language language) {
        return Response
                .<D>builder()
                .mess(ResourceBundle.periodMess(key, language))
                .build();
    }
}
