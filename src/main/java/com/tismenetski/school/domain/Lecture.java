package com.tismenetski.school.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "subjectLectures")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacherLectures")
    private Teacher teacher;

    @ManyToMany(mappedBy = "studentLectures")
    private List<Student> lectureStudents;
}
