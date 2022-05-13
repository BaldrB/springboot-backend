package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "Dorama")

public class Dorama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "dorama_name")
    private String doramaName;

    @Column(name = "dorama_descript")
    private String doramaDescript;

    @Column(name = "dorama_img")
    private String doramaImg;

    @Column(name = "dorama_city")
    private String doramaCity;

    @Column
    private List<String> doramaTag;
    
}
