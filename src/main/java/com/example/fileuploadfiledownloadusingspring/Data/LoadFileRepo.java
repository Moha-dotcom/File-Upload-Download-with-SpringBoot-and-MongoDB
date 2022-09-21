package com.example.fileuploadfiledownloadusingspring.Data;

import com.example.fileuploadfiledownloadusingspring.Entity.LoadFile;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoadFileRepo extends MongoRepository<LoadFile, String> {

    GridFSFile findLoadFileById(String id);
}
