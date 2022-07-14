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

    @Lob
    @Column(name = "dorama_descript")
    private String doramaDescript;

    @Column(name = "dorama_img")
    private String doramaImg;

    @Column(name = "dorama_city")
    private String doramaCity;

    @Lob
    private byte[] data;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "dorama_tagdorama", joinColumns = @JoinColumn(name = "dorama_id"), inverseJoinColumns = @JoinColumn(name = "tagdorama_id"))
    private List<Tagdorama> doramaTag = new ArrayList<>();

    public void addDoramaTag(Tagdorama tagdorama) {
        this.doramaTag.add(tagdorama);
        tagdorama.getDorama().add(this);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    // public Dorama() {}

    // public long getId() {
    // return this.id;
    // }

    // public void setId(long id) {
    // this.id = id;
    // }

    // public List<Tagdorama> getTagdorama() {
    // return this.dorama;
    // }

    // public void setTagdorama(List<Tagdorama> dorama) {
    // this.dorama = dorama;
    // }

}
