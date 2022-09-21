package com.example.fileuploadfiledownloadusingspring.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "FileUploaded")
@Data
@Getter
@Setter
@ToString

public class LoadFile {


    @Id
    private Id id;
    @Field
    private String filename;
    @Field
    private String fileType;
    @Field
    private String fileSize;
    @Field
    private byte[] file;
}
