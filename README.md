# File-Upload-Download-with-SpringBoot-and-MongoDB

 Simple RESTful web service using SpringBoot and MongoDB. I used  GridFS to store files.
 GridFS is a specification for storing and retrieving files that exceed the BSON-document size limit of 16MB. 
 
 GridFS uses two collections to store files.
    - fs.files - store file’s metadata.
    - fs.chunks - store binary chunks of the file.
    
    <img width="704" alt="Screen Shot 2022-09-21 at 1 54 39 PM" src="https://user-images.githubusercontent.com/77897855/191587600-d07c4cc3-40c6-4e07-9535-d65785cd923e.png">

    
<img width="996" alt="Screen Shot 2022-09-21 at 1 54 59 PM" src="https://user-images.githubusercontent.com/77897855/191587305-85f6d9c2-bb10-416b-a780-cb07bac9c23e.png">
