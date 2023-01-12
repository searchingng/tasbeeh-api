package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ByteFile {

    private byte[] body;
    private String fileName;
    private String extension;

}
