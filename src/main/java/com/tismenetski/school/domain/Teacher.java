package com.tismenetski.school.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name="teachers_subjects",joinColumns = @JoinColumn(name="teacher_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> teacherSubjects;

    @ManyToMany(mappedBy = "studentTeachers")
    private List<Student> teacherStudents;

    @ManyToMany
    @JoinTable(name="teachers_classes",joinColumns = @JoinColumn(name="teacher_id"),inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<Class> teacherClasses;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Lecture> teacherLectures;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Test> teacherTests;

}
