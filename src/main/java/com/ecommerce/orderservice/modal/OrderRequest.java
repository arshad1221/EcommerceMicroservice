package com.ecommerce.orderservice.modal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class OrderRequest {

	
	
	
	private long productid;
	
	
	private long amount;
	
	
	private long quantity;
	
	
	private PaymentMode payment;
	
			
}
