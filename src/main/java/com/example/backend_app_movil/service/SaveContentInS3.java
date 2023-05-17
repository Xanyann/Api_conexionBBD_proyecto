package com.example.backend_app_movil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.internal.resource.S3ObjectResource;
import software.amazon.awssdk.services.s3.model.*;



import java.nio.charset.StandardCharsets;
import java.security.Policy;
import java.security.Principal;
import java.sql.Statement;
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
       //setPublicAccessPolicy(bucketName, fileName);

        return client.utilities().getUrl(request).toExternalForm();
    }
/*
    private void setPublicAccessPolicy(String bucketName, String fileName) {
        Policy policy = new Policy();
        policy.addStatements(new Statement(Effect.Allow)
                .withPrincipals(Principal.AllUsers)
                .withActions(S3Actions.GetObject)
                .withResources(new S3ObjectResource(bucketName, fileName)));

        PutBucketPolicyRequest putBucketPolicyRequest = PutBucketPolicyRequest.builder()
                .bucket(bucketName)
                .policy(policy.toJson())
                .build();

        client.putBucketPolicy(putBucketPolicyRequest);
    }
*/
}
