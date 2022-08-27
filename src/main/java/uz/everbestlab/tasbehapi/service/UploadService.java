package uz.everbestlab.tasbehapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

     String uploadFile(MultipartFile multipartFile);

     void deleteFile(String path);

}
