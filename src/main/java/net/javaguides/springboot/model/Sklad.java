package net.javaguides.springboot.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hardpc")
public class Sklad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "invet")
    private String invet;

    @Column(name = "system_name")
    private String systemName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "hardware")
    private String hardware;


}