package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "dorama", cascade=CascadeType.ALL)
    private List<Tagdorama> dorama;

    // public Dorama() {}

    // public long getId() {
    //     return this.id;
    // }

    // public void setId(long id) {
    //     this.id = id;
    // }

    // public List<Tagdorama> getTagdorama() {
    //     return this.dorama;
    // }

    // public void setTagdorama(List<Tagdorama> dorama) {
    //     this.dorama = dorama;
    // }
    
}
