package com.ecommerce.orderservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE/product")
@Component
public interface ProductService {

	@PutMapping("/reduce/{Pid}")
	public ResponseEntity<Void> reducePoductQuantity(@PathVariable long Pid, @RequestParam long quantity);

}
