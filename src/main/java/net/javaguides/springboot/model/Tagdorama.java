package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TagDorama")

public class Tagdorama {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dorama_id")
    private Dorama dorama;

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
