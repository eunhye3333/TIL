package egovframework.msa.sample.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import egovframework.msa.sample.service.CustomerApiService;

@Service
public class CustomerApiServiceImpl implements CustomerApiService {
	
	// RestTemplate 적용
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "getCustomerDetailFallback") // 에러 또는 지연되는 경우 사용할 메서드 지정
	public String getCustomerDetail(String customerId) {
//		return restTemplate.getForObject("http://localhost:8082/customers/" + customerId, String.class);
		return restTemplate.getForObject("http://customer/customers/" + customerId, String.class); // application.yml에서 설정한 명시적인 서비스명으로 변경
	}
	
	// fallback 메서드
	public String getCustomerDetailFallback(String customerId, Throwable ex) {
		System.out.println("Error : " + ex.getMessage());
		return "고객 정보 조회가 지연되고 있습니다.";
	}

}
