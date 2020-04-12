package com.tismenetski.school.repositories;

import com.tismenetski.school.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {


    Student findById(String id);


}
