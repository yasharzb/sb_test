package edu.sharif.ce.ap.sbtest.client;

import edu.sharif.ce.ap.sbtest.configuration.MainConfig;
import edu.sharif.ce.ap.sbtest.model.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ClientMachine {
    @Autowired
    private MainConfig mainConfig;

    private RestTemplate restTemplate = new RestTemplate();

    public void createRegisterRequest() {
        StudentDTO studentDTO = new StudentDTO(4, 9780, "ali", "alive");
        HttpEntity<StudentDTO> httpEntity = new HttpEntity<>(studentDTO);
        sendRequest(mainConfig.getRegisterPath(), HttpMethod.POST, httpEntity);
    }

    private void sendRequest(String path, HttpMethod method, HttpEntity entity) {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(mainConfig.getUri()).append(path);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uriBuilder.toString(), method, entity, String.class);
        log.info("Response is {}, {}", responseEntity.getBody(), responseEntity.getStatusCode());
    }
}
