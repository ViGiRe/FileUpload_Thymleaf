package com.app.FileUpload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.FileUpload.modal.File;

public interface FileRepository extends JpaRepository<File, Long>{

}
