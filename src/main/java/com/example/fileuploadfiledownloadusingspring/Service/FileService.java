package com.example.fileuploadfiledownloadusingspring.Service;

import com.example.fileuploadfiledownloadusingspring.Data.Id;
import com.example.fileuploadfiledownloadusingspring.Data.LoadFileRepo;
import com.example.fileuploadfiledownloadusingspring.Entity.LoadFile;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    LoadFileRepo repo;

    public String UploadFile(MultipartFile file) throws IOException {
        DBObject meta = new BasicDBObject ();
        meta.put ("FileSize" , file.getSize ());

        Object fileId = template.store (file.getInputStream (), file.getOriginalFilename (), file.getContentType (), meta );

        return fileId.toString ();
    }

    public LoadFile downloadFile(String id) throws IOException {

        GridFSFile gridFSFile = repo.findLoadFileById (id);

//        GridFSFile gridFSFile = template.findOne( new Query(Criteria.where("_id").is(id)) );

        LoadFile loadFile = new LoadFile();

        if (gridFSFile != null && gridFSFile.getMetadata() != null) {
            loadFile.setFilename( gridFSFile.getFilename() );

            loadFile.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

            loadFile.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

            loadFile.setFile( IOUtils.toByteArray(operations.getResource(gridFSFile).getInputStream()) );
        }

        return loadFile;
    }
}
