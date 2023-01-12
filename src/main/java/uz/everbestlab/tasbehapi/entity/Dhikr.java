package uz.everbestlab.tasbehapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dhikr extends BaseEntity{

    private String transliteration;

    private String translation;

    private String arabic;

    private String voicePath;

}
