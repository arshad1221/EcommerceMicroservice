package com.ecommerce.orderservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.external.ProductService;
import com.ecommerce.orderservice.modal.OrderRequest;
import com.ecommerce.orderservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
class OrderServiceImpl  implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private ProductService productService;
	
	@Override
	public long placeorder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		
		log.info("placing order");
		log.info("calling product service");
		productService.reducePoductQuantity(orderRequest.getProductid(), orderRequest.getQuantity());
		Order o=Order.builder()
				.productid(orderRequest.getProductid())
				.amount(orderRequest.getAmount())
				.status("placed")
				.quantity(orderRequest.getQuantity())
				.orderDate(Instant.now()).
				build();
		orderRepository.save(o);
		log.info(" order placed suceefully with orderId:{}",o.getId());
		
		
		return o.getId();
	}

}
