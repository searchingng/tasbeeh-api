package uz.everbestlab.tasbehapi.service;

import org.springframework.web.multipart.MultipartFile;
import uz.everbestlab.tasbehapi.dto.ByteFile;

public interface UploadService {

     String uploadFile(MultipartFile multipartFile);

     void deleteFile(String path);

     ByteFile getByteFile(String imagePath);
}
