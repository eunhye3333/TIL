package egovframework.msa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient// @EnableEurekaServer와 동일하게 작동하지만 @EnableEurekaServer는 Eureka 서버일 경우에만 작동하고, @EnableDiscoveryClient는 Eureka 뿐만 아니라 Consul, Zookeeper도 지원
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}

}
