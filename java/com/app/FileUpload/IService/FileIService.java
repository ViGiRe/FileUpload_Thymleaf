package com.app.FileUpload.IService;

import java.util.List;

import com.app.FileUpload.modal.File;

public interface FileIService {
	List<File> getAllFiles();
    void saveAllFilesList(List<File> fileList);
}
