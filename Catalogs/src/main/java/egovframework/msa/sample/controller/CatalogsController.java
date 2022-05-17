package egovframework.msa.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.msa.sample.service.CustomerApiService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/catalogs/customerinfo")
public class CatalogsController {
	
	@Autowired
	private CustomerApiService customerApiService;
	
	@GetMapping(path = "/{customerId}")
	public String getCustomerInfo(@PathVariable String customerId) { // @PathVariable : url의 파라미터를 가져오는 경우 사용
		String customerInfo = customerApiService.getCustomerDetail(customerId);
		
		System.out.println("response customerInfo : " + customerInfo);
		
		return String.format("[Customer id = %s at %s %s ]", customerId, System.currentTimeMillis(), customerInfo);
	}
}
