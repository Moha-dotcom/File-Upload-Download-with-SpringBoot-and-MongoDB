# File-Upload-Download-with-SpringBoot-and-MongoDB

 Simple RESTful web service using SpringBoot and MongoDB. I used  GridFS to store files.
 GridFS is a specification for storing and retrieving files that exceed the BSON-document size limit of 16MB. 
 
 GridFS uses two collections to store files.
    - fs.files - store file’s metadata.
    - fs.chunks - store binary chunks of the file.
