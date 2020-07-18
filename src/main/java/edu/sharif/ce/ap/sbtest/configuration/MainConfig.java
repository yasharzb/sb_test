package edu.sharif.ce.ap.sbtest.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class MainConfig {
    private String uri;
    private String registerPath;
    private String showInfoPath;
    private String findAllByNamePath;
}
