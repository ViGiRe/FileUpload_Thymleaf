package com.app.FileUpload.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.FileUpload.IService.FileIService;
import com.app.FileUpload.Repository.FileRepository;
import com.app.FileUpload.modal.File;

//@Service annotation is used with classes
//that provide some business functionalities
@Service
public class FileService implements FileIService {

 // @Autowired annotation used to inject 
 // the object dependency of FileRepository
 @Autowired 
 FileRepository fileRepository;

 @Override
 public List<File> getAllFiles() {
     // fetch all the files form database
     return fileRepository.findAll();
 }
 public void saveAllFilesList(List<File> fileList) {
     // Save all the files into database
     for (File File : fileList)
         fileRepository.save(File);
 }
}
