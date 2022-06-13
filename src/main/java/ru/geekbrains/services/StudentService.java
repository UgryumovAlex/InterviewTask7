package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Student;
import ru.geekbrains.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setProductRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id);
    }

    public void remove(Long id) {
        studentRepository.remove(id);
    }

    public void add(Student student) {
        studentRepository.add(student);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }
}
