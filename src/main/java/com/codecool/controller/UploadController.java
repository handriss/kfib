package com.codecool.controller;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/admin")
public class UploadController {

    @GetMapping("/upload-file")
    public String homeUpload(){

        log.info("upload called with get method...");

        return "admin/upload";
    }

    @PostMapping("/upload-file")
    public String saveFile(@RequestParam("name") String name, @RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){

        AWSCredentials credentials = new BasicAWSCredentials("", "");


        AmazonS3 s3client = new AmazonS3Client(credentials);

        String bucketName = "kfib-" + UUID.randomUUID();

        s3client.createBucket(bucketName);

        ObjectMetadata md = new ObjectMetadata();
        md.setContentType("application/pdf");

        try{
            InputStream inputStream = file.getInputStream();

            s3client.putObject(new PutObjectRequest(bucketName, name, inputStream, md).withCannedAcl(CannedAccessControlList.PublicRead));

            S3Object s3Object = s3client.getObject(new GetObjectRequest(bucketName, name));

            log.info("Url of the image:\n");
            log.info(s3Object.getObjectContent().getHttpRequest().getURI().toString());

        }catch(IOException e){
            e.printStackTrace();
        }


        log.info("upload called with post method...");

        return "redirect:/admin/posts";
    }

}
