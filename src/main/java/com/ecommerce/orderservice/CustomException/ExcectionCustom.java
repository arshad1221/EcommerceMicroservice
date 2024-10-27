package com.ecommerce.orderservice.CustomException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcectionCustom extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ErrorCode;
	private Integer status;

	public ExcectionCustom(String message, String ErrorCode, int status) {
		super(message);

		this.ErrorCode = ErrorCode;
		this.status = status;

	}

}
