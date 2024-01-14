package com.example.cinema.microservices.jsons;

import lombok.Data;

@Data
public class FileResponse {
    String fileName;
    String downloadUri;
    String fileType;
    String size;
}
