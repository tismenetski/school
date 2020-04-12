package com.tismenetski.school.services.serviceImpl;

import com.tismenetski.school.domain.Student;
import com.tismenetski.school.exceptions.StudentNotFoundException;
import com.tismenetski.school.repositories.StudentRepository;
import com.tismenetski.school.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveOrUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(String id) {

        Student student = studentRepository.findById(id);
        if (student == null) throw new StudentNotFoundException("Student with id: " + id + " not found");
        return student;
    }

    @Override
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(String studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) throw  new StudentNotFoundException("Cannot delete student with ID: "+ studentId+" .This student doesn't exist");
        studentRepository.delete(student);
    }
}
