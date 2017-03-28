package com.codecool.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class UploadController {


//    @GetMapping("/upload-file")
//    public String homeUpload(){
//
//        return "admin/upload";
//    }
//
//    @PostMapping("/upload-file")
//    public String saveFile(@RequestParam("name") String name, @RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
//
//        AWSCredentials credentials = new BasicAWSCredentials("", "");
//
//        AmazonS3 s3Client = new AmazonS3Client(credentials);
//
//        String bucketName = "kfib-proba";
//
//        s3Client.createBucket(bucketName);
//
//        ObjectMetadata md = new ObjectMetadata();
//        md.setContentType("application/pdf");
//
//        try{
//            InputStream inputStream = file.getInputStream();
//
//            s3Client.putObject(new PutObjectRequest(bucketName, name, inputStream, md).withCannedAcl(CannedAccessControlList.PublicRead));
//
//            S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, name));
//
//            log.info("Url of the image:\n");
//            log.info(s3Object.getObjectContent().getHttpRequest().getURI().toString());
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//        return "redirect:/admin/posts";
//    }

}
