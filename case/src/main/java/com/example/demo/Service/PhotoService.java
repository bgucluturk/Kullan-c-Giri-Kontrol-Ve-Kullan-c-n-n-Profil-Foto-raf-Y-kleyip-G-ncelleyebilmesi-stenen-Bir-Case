package com.example.demo.Service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.Photo;
import com.example.demo.Repository.PhotoRepository;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public String uploadPhoto(MultipartFile file, Long userId) throws IOException {
        // Dosya adını değiştirme veya işleme yapabilirsiniz
        @SuppressWarnings("null")
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Photo photo = new Photo(fileName, file.getContentType(), file.getBytes(), userId);
        photoRepository.save(photo);

        return fileName;
    }
}





