package net.javaguides.springboot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String name;
     
    private String description;
 
    // constructors, getter and setters are not shown for brevity  
}