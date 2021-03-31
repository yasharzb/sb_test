package edu.sharif.ce.ap.sbtest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.Nullable;
import edu.sharif.ce.ap.sbtest.model.dto.StudentDTO;
import edu.sharif.ce.ap.sbtest.model.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private static int studentId = 97101010;
    private static StudentDTO studentDTO;
    private static boolean isStarted = false;

    @PostConstruct
    public void init() {
        if (isStarted)
            return;;
        studentRepository.deleteAll();
        isStarted = true;
    }

    @BeforeAll
    public static void setup() {
        int id = 5;
        String name = "name";
        String bio = "bio";
        studentDTO = new StudentDTO(id, studentId, name, bio);
    }

    @Order(1)
    @Test
    public void registerTest() throws Exception {
        performPostRequest("/register", studentDTO, HttpStatus.OK.value(), null);
    }

    @Order(2)
    @Test
    public void showInfoTest() throws Exception {
        MvcResult mvcResult = performGetRequest("/show_info", "si", studentId);
        StudentDTO result = mapper.readValue(mvcResult.getResponse().getContentAsString(), StudentDTO.class);
        assertEquals(studentDTO, result);
    }

    private MvcResult performPostRequest(String uri, Object content, int status, @Nullable Map<String, Integer> params)
            throws Exception {
        MockHttpServletRequestBuilder builder = post(uri);
        if (Objects.nonNull(params))
            params.forEach((key, val) -> builder.queryParam(key, Integer.toString(val)));
        return mockMvc.perform(builder.contentType("application/json")
                .content(mapper.writeValueAsString(content))).andExpect(status().is(status)).andReturn();
    }

    private MvcResult performGetRequest(String uri, String queryKey, Integer queryValue) throws Exception {
        return mockMvc.perform(get(uri)
                .queryParam(queryKey, Integer.toString(queryValue)))
                .andExpect(status().isOk()).andReturn();
    }
}