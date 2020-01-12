package com.centdom.hibernate_relational_mapping.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name = "instructor")
@Component
public class Instructor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "instructor_detail_id")
    private String instructorDetailId;



}
