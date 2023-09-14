package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {
    Environment env; // 스프링 환경 설정에 접근할 수 있는 인터페이스

    @Autowired
    public FirstServiceController(Environment env){
        this.env = env;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the First service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        log.info(header);
        return "First Service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        Enumeration<String> headers = request.getAttributeNames();

        Collections.list(headers).stream().forEach(name -> {
            Enumeration<String> values = request.getHeaders(name);
            Collections.list(values).stream().forEach(value -> System.out.println(name + "=" + value));
        });

        log.info("Server port={}", request.getServerPort());

        log.info("spring.cloud.client.hostname={}", env.getProperty("spring.cloud.client.hostname"));
        log.info("spring.cloud.client.ip-address={}", env.getProperty("spring.cloud.client.ip-address"));

        return String.format("This is a message from First Service on PORT %s", env.getProperty("local.server.port"));
    }
}
