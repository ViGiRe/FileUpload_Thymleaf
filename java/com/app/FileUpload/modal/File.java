package com.app.FileUpload.modal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

// Entity annotation defines that a 
// class can be mapped to a table
@jakarta.persistence.Entity

// @Table annotation defines name of the table
@Table(name = "filemodal") 
public class File {
	// @Id annotation specifies the
	// primary key of an entity
	@jakarta.persistence.Id

	// @GeneratedValue annotation Provides for the 
	// specification of generation strategies
	// for the values of primary keys
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	// @Column annotation specifies
	// the name of the column
	@Column(name = "id") 
	Long id;
	@Column(name = "name")
	String fileName;
	@Lob
	@Column(name = "content")
	String content;
	
	@Column(name = "filetype")
	private String fileType;

	public File() {
		super();
	}
	public File(String fileName, String content, String fileType) {
		super();
		this.fileName = fileName;
		this.content = content;
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}

