package com.centdom.hibernate_relational_mapping.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.*;

@Data
@Entity
@Table(name = "instructor")
@Component
public class Instructor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetailId;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;


}
