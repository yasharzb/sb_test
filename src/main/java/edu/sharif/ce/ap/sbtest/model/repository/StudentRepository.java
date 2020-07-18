package edu.sharif.ce.ap.sbtest.model.repository;

import edu.sharif.ce.ap.sbtest.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAllByName(String name);

    Student findByStudentId(int studentId);

    List<Student> findAllByStudentIdGreaterThan(int id);
}