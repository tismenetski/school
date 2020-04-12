package com.tismenetski.school.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank()
    private String name;

    @NotBlank
    @Size(min=9,max = 9)
    @Column(unique = true, updatable = false)
    private String socialId;

    @NotBlank
    @Size(min=10,max = 10)
    private String phoneNumber;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6,max = 12)
    private String password;

    @NotNull
    @Range(min = 0,max = 7)
    private Integer year;

    @ManyToOne()
    @JoinColumn(name = "classStudents")
    private Class studentClass;

    @ManyToMany
    @JoinTable(name="students_teachers",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> studentTeachers;

    @ManyToMany
    @JoinTable(name="students_subjects",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> studentSubjects;

    @ManyToMany
    @JoinTable(name="students_lectures",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> studentLectures;

    @ManyToMany
    @JoinTable(name="students_tests",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "test_id"))
    private List<Test> studentTests;


    private Date startDate;
    private Date endDate;
    private boolean isActive;
}
