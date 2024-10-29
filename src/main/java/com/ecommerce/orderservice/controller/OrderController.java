package com.ecommerce.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.orderservice.external.ProductService;
import com.ecommerce.orderservice.modal.OrderRequest;
import com.ecommerce.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public OrderService orderService;

	@Autowired
	public ProductService productService;

	@PostMapping("/placeorde")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {

		long orderId = orderService.placeorder(orderRequest);
		productService.reducePoductQuantity(orderRequest.getProductid(), orderRequest.getQuantity());

		return new ResponseEntity<>(orderId, HttpStatus.CREATED);

	}

	@GetMapping("/test")
	public String test() {

		return "working Fine";
	}
}
