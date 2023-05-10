package com.example.backend_app_movil.api;


import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.api.dto.Register;
import com.example.backend_app_movil.model.repository.FileRepository;
import com.example.backend_app_movil.service.SaveContentInS3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class FileController {


    private final FileRepository fileRepository;
    private final SaveContentInS3 saveContentInS3;

    @PostMapping("file")
    public ResponseEntity<Files> saveFile(@RequestBody Files file) {
        try {
            String urlFile = saveContentInS3.saveFile(file.getNamefile(), file.getFile());
            file.setFile(urlFile);
            Files savedFile = fileRepository.save(file);
            System.out.println(file);
            return ResponseEntity.ok(savedFile);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
