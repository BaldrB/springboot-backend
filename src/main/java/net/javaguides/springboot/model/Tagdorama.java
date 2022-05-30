package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TagDorama")

public class Tagdorama {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String tag;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "doramaTag", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Dorama> dorama = new ArrayList<>();


    // public Tagdorama() {
    // }

    // public Integer getId() {
    //     return this.id;
    // }

    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public String getTag() {
    //     return this.tag;
    // }

    // public void setTag(String tag) {
    //     this.tag = tag;
    // }

    // public Dorama getDorama() {
    //     return this.dorama;
    // }
    // public void setDorama(Dorama dorama) {
    //     this.dorama = dorama;
    // }

}
