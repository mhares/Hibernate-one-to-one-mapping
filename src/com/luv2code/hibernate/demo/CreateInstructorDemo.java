package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;


public class CreateInstructorDemo {
    public static void main(String[] args) throws ParseException {
        SessionFactory factory = new Configuration()
                                      .configure()
                                      .addAnnotatedClass(Instructor.class)
                                      .addAnnotatedClass(InstructorDetail.class)
                                      .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int id=2;
            session.beginTransaction();
        InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,id);
            System.out.println(tempInstructorDetail);
            System.out.println(tempInstructorDetail.getInstructor());
            session.getTransaction().commit();

        }finally {
          session.close();
        }
    }
}
