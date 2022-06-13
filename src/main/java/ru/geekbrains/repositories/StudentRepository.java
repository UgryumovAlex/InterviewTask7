package ru.geekbrains.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Student;

import java.util.List;

@Repository
public class StudentRepository {

    private SessionFactory factory;

    public StudentRepository() {
        this.factory = HibernateFactory.getFactory();
    }

    public void add(Student student) {
        Session session = this.factory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

    }

    public void update(Student student) {
        Session session = this.factory.getCurrentSession();
        session.beginTransaction();
        Student studentUpdate = session.get(Student.class, student.getStudent_id());
        studentUpdate.setStudent_name(student.getStudent_name());
        studentUpdate.setStudent_age(student.getStudent_age());
        session.getTransaction().commit();
    }

    public void remove(long id) {
        Session session = this.factory.getCurrentSession();
        session.beginTransaction();
        Student studentDelete = session.get(Student.class, id);
        session.delete(studentDelete);
        session.getTransaction().commit();
    }

    public Student findById(long id) {
        Session session = this.factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();

        return student;
    }

    public List<Student> findAll() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();

        return students;
    }
}
