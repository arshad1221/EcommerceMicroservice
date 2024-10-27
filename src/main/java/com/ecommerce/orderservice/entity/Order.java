package com.ecommerce.orderservice.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="ORDER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="PRODUCT_ID")
	private long productid;
	
	@Column(name="ORDER_AMOUNT")
	private long amount;
	
	@Column(name="ORDER_QUANTITY")
	private long quantity;
	
	@Column(name="ORDER_DATE")
	private Instant orderDate;
	
	
	@Column(name="ORDER_STATUS")
	private String status;
	

}
