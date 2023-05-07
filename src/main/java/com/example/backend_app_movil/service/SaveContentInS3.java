package com.example.backend_app_movil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class SaveContentInS3 {

    private final S3Client client;


    public String saveFile(String fileName, String base64) {
        byte[] decode = Base64.getDecoder().decode(base64.getBytes(StandardCharsets.UTF_8));
        String bucketName = "tecnologoproyecto";
        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(fileName).build();
        PutObjectResponse putObjectResponse = client.putObject(putObjectRequest, RequestBody.fromBytes(decode));
        GetUrlRequest request = GetUrlRequest.builder().bucket(bucketName).key(fileName).build();
        return client.utilities().getUrl(request).toExternalForm();
    }

}
