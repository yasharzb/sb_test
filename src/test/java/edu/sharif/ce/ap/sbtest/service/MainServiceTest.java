package edu.sharif.ce.ap.sbtest.service;

import edu.sharif.ce.ap.sbtest.model.entity.Student;
import edu.sharif.ce.ap.sbtest.model.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class MainServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private MainService mainService;

    @Test
    public void registerTest() {
        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(12);
        myList.add(56);
        myList.add(-4);
        myList.forEach(num -> log.info("My number is {}", num));
        AtomicBoolean isSaved = new AtomicBoolean(false);
        int id = 4;
        int studentId = 97101010;
        String name = "name";
        String bio = "bio";
        Student student = new Student(id, studentId, name, bio);
        when(studentRepository.save(student)).thenAnswer(invocation -> {
            log.error("Felan");
//            isSaved.set(true);
            return null;
        });
        mainService.register(id, studentId, name, bio);
        verify(studentRepository).save(student);
//        assertTrue(isSaved.get());
    }

}