package com.tismenetski.school.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subjectTests")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacherTests")
    private Teacher teacher;

    @ManyToMany(mappedBy = "studentTests")
    private List<Student> testStudents;

    private String name;
    private Double weight;

}
