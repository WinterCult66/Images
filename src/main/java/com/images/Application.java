package com.images;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static final String LOG_FILE_NAME = "imagenes";
    @Value("${image.dir}")
    private String imageDirectory;

    public static void main(String[] args) {
        String appCurrentDir = System.getProperty("user.dir");
        String logFullPath = appCurrentDir + File.separator + LOG_FILE_NAME;

        Map<String, Object> defaultProperties = new HashMap<>();
        defaultProperties.put("logging.file", logFullPath);
        defaultProperties.put("logging.level.root", "WARN");
        defaultProperties.put("logging.level.org.springframework", "INFO");
        defaultProperties.put("logging.level.com.images", "INFO");
        defaultProperties.put("server.port", "7575");
        defaultProperties.put("image.dir", "D:\\In");
        defaultProperties.put("management.port", "-1");
        printProperties(defaultProperties);
        SpringApplication spApp = new SpringApplication(Application.class);
        spApp.setDefaultProperties(defaultProperties);        
        log.info("RUNING START");
        spApp.run(args);
        //SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void init() {
        log.info("# Images directory  : {}       ", imageDirectory);

    }

    private static void printProperties(Map<String, Object> p) {
        for (Map.Entry<String, Object> entry : p.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            log.info("{}  : {}", key, value);
        }
    }

}
