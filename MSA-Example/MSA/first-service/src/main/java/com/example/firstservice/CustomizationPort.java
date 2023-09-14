package com.example.firstservice;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomizationPort implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory server) {
        Random random = new Random(); // 현재 시스템 시간을 seed 값으로 가지는 난수 생성

        int port = random.ints(10000, 51000)
                .findFirst()
                .getAsInt();

        server.setPort(port);
    }
}
