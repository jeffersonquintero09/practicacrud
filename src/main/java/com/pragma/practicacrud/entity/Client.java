package com.pragma.practicacrud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID = -5059274382180392989L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter
    @Column(length = 50)
    private String name; // Nombre

    @Getter @Setter
    private String surname; // Apellidos

    @Getter @Setter
    private String typeId; // Tipo de identificación

    @Getter @Setter
    @Column(unique = true)
    private String idNumber; // Número de identificación

    @Getter @Setter
    private int age; // Edad

    @Getter @Setter
    private String city; // Ciudad de nacimiento
}
