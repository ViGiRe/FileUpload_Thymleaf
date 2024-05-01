package com.app.FileUpload.Controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.FileUpload.modal.File;
import com.app.FileUpload.serviceImpl.FileService;
@RestController
public class FileController {

	 @Autowired
	    FileService fileService;
	 
	    // @GetMapping annotation for 
	    // mapping HTTP GET requests onto
	    // specific handler methods. */
	    @GetMapping("/") 
	    public String getData() {
	        return "File";
	    }
	   
	    // @PostMapping annotation maps HTTP POST 
	    // requests onto specific handler methods
	    @PostMapping("/") 
	    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal) {
	    try {
	        // Declare empty list for collect the files data 
	        // which will come from UI
	        List<File> fileList = new ArrayList<>();
	        for (MultipartFile file : files) {
	            String fileContentType = file.getContentType();
	            String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
	            String fileName = file.getOriginalFilename();
	            File File = new File(fileName, sourceFileContent, fileContentType);
	             
	            // Adding file into fileList
	            fileList.add(File);
	            }
	       
	            // Saving all the list item into database
	            fileService.saveAllFilesList(fileList);
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	       
	        // Send file list to View using modal class    
	        // fileService.getAllFiles() used to 
	        // fetch all file list from DB
	        modal.addAttribute("allFiles", fileService.getAllFiles());
	       
	        return "FileList";
	    }
}
