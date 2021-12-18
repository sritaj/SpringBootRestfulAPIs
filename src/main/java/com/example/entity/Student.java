package com.example.entity;


import com.example.request.CreateRequestStudent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Transient
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(CreateRequestStudent createRequestStudent){
        this.firstName = createRequestStudent.getFirstName();
        this.lastName = createRequestStudent.getLastName();
        this.email = createRequestStudent.getEmail();
        this.fullName = createRequestStudent.getFirstName() + " " + createRequestStudent.getLastName();
    }
}
