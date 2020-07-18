package edu.sharif.ce.ap.sbtest.controller;

import edu.sharif.ce.ap.sbtest.model.dto.StudentDTO;
import edu.sharif.ce.ap.sbtest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping(value = "/register")
    private void register(@RequestBody StudentDTO dto) {
        mainService.register(dto.getId(), dto.getStudentId(), dto.getName(), dto.getBio());
    }

    @GetMapping(value = "/find_all")
    private List<StudentDTO> findAllByName(@RequestParam(name = "name") String name) {
        List<StudentDTO> list = mainService.findAllByName(name);
        return list;
    }

    @GetMapping(value = "/show_info")
    private StudentDTO showInfo(@RequestParam(name = "si") int studentId) {
        StudentDTO studentDTO = mainService.showInfo(studentId);
        return studentDTO;
    }
}
