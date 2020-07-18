package edu.sharif.ce.ap.sbtest.service;

import edu.sharif.ce.ap.sbtest.model.dto.StudentDTO;
import edu.sharif.ce.ap.sbtest.model.entity.Student;
import edu.sharif.ce.ap.sbtest.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void setup(){
        System.out.println("Hey");
    }
    public void register(int id, int studentId, String name, String bio) {
        Student student = new Student(id, studentId, name, bio);
        studentRepository.save(student);
    }

    public List<StudentDTO> findAllByName(String name) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentRepository.findAllByName(name).forEach(student -> {
            StudentDTO studentDTO = new StudentDTO(student.getStudentId(), student.getName(), student.getBio());
            studentDTOList.add(studentDTO);
        });
        return studentDTOList;
    }

    public StudentDTO showInfo(int studentId) {
        Student student = studentRepository.findByStudentId(studentId);
        return new StudentDTO(student.getStudentId(), student.getName(), student.getBio());
    }
}
