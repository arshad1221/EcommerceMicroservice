package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.modal.OrderRequest;


public interface OrderService {

	long placeorder(OrderRequest orderRequest);

}
