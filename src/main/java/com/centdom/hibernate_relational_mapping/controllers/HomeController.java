package com.centdom.hibernate_relational_mapping.controllers;

import com.centdom.hibernate_relational_mapping.models.Course;
import com.centdom.hibernate_relational_mapping.models.Instructor;
import com.centdom.hibernate_relational_mapping.models.InstructorDetail;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {

    private InstructorDetail instructorDetail;
    private Instructor instructor;
    public EntityManager manager;
    @Autowired
    private Course course;

    private Session session;

    @Autowired
    public HomeController(EntityManager manager, InstructorDetail detail, Instructor instructor) {
        this.manager = manager;
        this.instructorDetail = detail;
        this.instructor = instructor;
    }

    private Session createSession() {
        return this.manager.unwrap(Session.class);
    }

    @GetMapping
    public String home() {
        Session session = this.createSession();
        try {
            session.beginTransaction();
//        instructorDetail.setYoutubeChannel("http://thisisit.com");
//        instructorDetail.setHobby("Hobby1");
//        instructor.setEmail("hhh@sgs.com");
//        instructor.setFirstName("mike");
//        instructor.setLastName("ejeagha");
//        instructor.setInstructorDetailId(instructorDetail);
//        session.save(instructor);
//        session.createQuery("delete from Instructor where firstName like 'Jero'").executeUpdate();

//        instructor.setEmail("hhh@sgs.com");
//        instructor.setFirstName("mike");
//        instructor.setLastName("ejeagha");
//        course.setInstructor(instructor);
//        course.setTitle("Title one");

//        session.save(course);

            Instructor instructor = session.get(Instructor.class, 1);
            Query<Instructor> query = session.createQuery("from Instructor where Id = 1");

            Instructor instructor1 = query.getSingleResult();

            List<Course> c = instructor1.getCourses();
            log.info(c.toString());


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            manager.close();
        }
        return "home";

    }

}
