package com.example.fileuploadfiledownloadusingspring.Data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Data
@Document
public class Id {

    @org.springframework.data.annotation.Id
    private ObjectId id;
}
