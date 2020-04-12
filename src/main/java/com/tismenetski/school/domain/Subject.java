package com.tismenetski.school.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "teacherSubjects")
    private List<Teacher> subjectTeachers;

    @ManyToMany(mappedBy = "studentSubjects")
    private List<Student> subjectStudents;

    @ManyToMany(mappedBy = "classSubjects")
    private List<Class> subjectClasses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "subject",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Lecture> subjectLectures;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "subject",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Test> subjectTests;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "subject",fetch = FetchType.LAZY)
    private List<Assignment> subjectAssignments;
}
