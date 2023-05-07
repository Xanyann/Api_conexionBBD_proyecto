package com.example.backend_app_movil.api;


import com.example.backend_app_movil.api.dto.Files;
import com.example.backend_app_movil.model.repository.FileRepository;
import com.example.backend_app_movil.service.SaveContentInS3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class FileController {


    private final FileRepository fileRepository;
    private final SaveContentInS3 saveContentInS3;

    @PostMapping("files")
    public ResponseEntity<String> saveUser(@RequestBody Files file) {
        try {
            String urlFile = saveContentInS3.saveFile(file.getName(), file.getFile());
            file.setFile(urlFile);
            fileRepository.save(file);
            System.out.println(file);
            return ResponseEntity.ok("Archivo guardado correctamente" + file);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al registrar el archivo");
        }
    }


}
