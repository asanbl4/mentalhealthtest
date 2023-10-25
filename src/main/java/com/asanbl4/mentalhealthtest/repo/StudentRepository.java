package com.asanbl4.mentalhealthtest.repo;

import com.asanbl4.mentalhealthtest.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
