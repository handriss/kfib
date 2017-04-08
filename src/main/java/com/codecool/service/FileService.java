package com.codecool.service;


import com.codecool.model.File;
import com.codecool.repository.FileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(File file){
        fileRepository.save(file);
    }

    public void delete(File file){
        fileRepository.delete(file);
    }

    public void deleteById(Long id){
        this.delete(fileRepository.findById(id));
    }

    public void deleteByName(String name){
        this.delete(fileRepository.findByName(name));
    }

    public List<File> findAll(){
        return fileRepository.findAll();
    }

    public File findById(Long id){
        return fileRepository.findById(id);
    }

    public File findByName(String name){
        return fileRepository.findByName(name);
    }

}
