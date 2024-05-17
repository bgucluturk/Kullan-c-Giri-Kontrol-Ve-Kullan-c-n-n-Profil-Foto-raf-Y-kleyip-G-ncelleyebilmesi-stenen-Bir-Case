package com.example.demo.Entity.UserDto;


import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoUploadDto {

    private Long userId;
    private MultipartFile photo; // Fotoğrafın base64 string hali veya dosya yolu
}
