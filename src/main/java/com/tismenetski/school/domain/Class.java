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
public class Class {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentClass",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> classStudents;

    @ManyToMany(mappedBy = "teacherClasses")
    private List<Teacher> classTeachers;

    @ManyToMany
    @JoinTable(name="class_subjects",joinColumns = @JoinColumn(name="class_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> classSubjects;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "assignmentClass",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Assignment> classAssignments;






}
