package com.tismenetski.school.services;

import com.tismenetski.school.domain.Student;

public interface StudentService {

    Student saveOrUpdateStudent(Student student);

    Student findStudentById(String  id);

    Iterable<Student> findAllStudents();

    void deleteStudentById(String studentId);
}
