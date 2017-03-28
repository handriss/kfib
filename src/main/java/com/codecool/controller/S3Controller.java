package com.codecool.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.codecool.model.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
@RequestMapping("/upload")
public class S3Controller {

    @RequestMapping(value="/json-proba/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Shop jsonProba(@PathVariable String name){

        Shop shop = new Shop();
        shop.setName(name);
        shop.setStaffName(new String[]{"nameOne", "nameTwo"});

        return shop;
    }

    @GetMapping("/upload-file")
    public String homeUpload(){

        return "admin/upload";
    }

    @PostMapping("/upload-file")
    public String saveFile(@RequestParam("name") String name, @RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){

        AWSCredentials credentials = new BasicAWSCredentials("", "");

        AmazonS3 s3Client = new AmazonS3Client(credentials);

        String bucketName = "kfib-proba";

        s3Client.createBucket(bucketName);

        ObjectMetadata md = new ObjectMetadata();
        md.setContentType("application/pdf");

        try{
            InputStream inputStream = file.getInputStream();

            s3Client.putObject(new PutObjectRequest(bucketName, name, inputStream, md).withCannedAcl(CannedAccessControlList.PublicRead));

            S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, name));

            log.info("Url of the image:\n");
            log.info(s3Object.getObjectContent().getHttpRequest().getURI().toString());

        }catch(IOException e){
            e.printStackTrace();
        }

        return "redirect:/admin/posts";
    }
}
