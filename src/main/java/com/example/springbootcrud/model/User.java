package com.example.springbootcrud.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    @NotBlank(message = "Name is mandatory")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;
}
