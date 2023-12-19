package com.example.Amusa.studentThymeleaf.model;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students", schema = "students", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private String dateOfBirth;

    @Column(name = "phone")
    private String phoneNumber;

    private String address;
}
