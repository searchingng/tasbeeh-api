package uz.everbestlab.tasbehapi.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.service.UploadService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${uploads.folder}")
    private String uploadFolder;

    public String uploadFile(MultipartFile multipartFile) {
        String uuid = UUID.randomUUID().toString();
        String path = uploadFolder + generateFolder();
        File folder = new File(path);
        if (!folder.exists())
            folder.mkdirs();

        path += "/" + uuid + "." + getExtension(multipartFile);
        File file = new File(path);

        try {
            multipartFile.transferTo(file);
            return path;
        } catch (IOException e) {
            //return default picture path
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    public void deleteFile(String path){
        if (!Objects.isNull(path)){
            File file = new File(path);
            if (file.exists())
                file.delete();
        }
    }

    private String generateFolder(){
        LocalDate date = LocalDate.now();
        return "/" + date.getYear() + "/" + date.getMonthValue();
    }

    private String getExtension(MultipartFile multipartFile){
        String name = multipartFile.getOriginalFilename();
        int dot = name.lastIndexOf(".");
        return name.substring(dot+1);
    }

}
