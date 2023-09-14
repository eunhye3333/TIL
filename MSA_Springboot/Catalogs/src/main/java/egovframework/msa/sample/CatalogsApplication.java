package egovframework.msa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("egovframework.*") // @Component 및  @Controller, @Service, @Repository 클래스들을 자동으로 Scan하여 Bean으로 등록하는 역할
@EnableCircuitBreaker // Hystrix를 사용한 Cricuit breaker 구현을 위한 어노테이션
@EnableEurekaClient // Eureka Client로 등록하는 어노테이션 
@SpringBootApplication
public class CatalogsApplication {

	// Customers를 호출하여 JSON 형태의 결과를 받기 위해 스프링에서 제공하는 RestTemplate을 적용
	@Bean
	@LoadBalanced // Ribbon을 적용하기 위한 어노테이션으로 Intercept를 통해 로드밸런서를 끼워넣어 로드밸런싱을 하도록 함
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogsApplication.class, args);
	}

}
