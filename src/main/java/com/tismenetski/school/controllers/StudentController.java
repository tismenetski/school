package com.tismenetski.school.controllers;

import com.tismenetski.school.domain.Student;
import com.tismenetski.school.services.MapValidationErrorService;
import com.tismenetski.school.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private  MapValidationErrorService mapValidationErrorService;

    @Autowired
    private StudentService studentService;

    //Create a new Student
    @PostMapping("")
    public ResponseEntity<?> createNewStudent(@Valid @RequestBody Student student , BindingResult result) //BindingResult is an interface that analyzes an object
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap!=null) return errorMap; // Returns the error map with a BAD_REQUEST Status

        Student returnValue = studentService.saveOrUpdateStudent(student);


        return new ResponseEntity<Student>(returnValue,HttpStatus.OK);
    }

    //Find Student by id
    @GetMapping("/{student_id}")
    public ResponseEntity<?> getStudentById(@PathVariable String student_id)
    {
        Student student = studentService.findStudentById(student_id);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }

    //Find all students
    @GetMapping("/all")
    public Iterable<Student> getAllStudents()
    {
        return studentService.findAllStudents();
    }

    //Delete Student by id
    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable String studentId)
    {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<String>("Student with ID: "+ studentId+ "Was Deleted",HttpStatus.OK);
    }



}
