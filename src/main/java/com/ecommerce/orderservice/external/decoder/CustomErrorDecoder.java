package com.ecommerce.orderservice.external.decoder;

import java.io.IOException;

import com.ecommerce.orderservice.CustomException.ExcectionCustom;
import com.ecommerce.orderservice.external.response.Errorresponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		log.info("::{}",response.request().url());
		log.info("::{}",response.request().headers());
		try {
			Errorresponse eerrRes = mapper.readValue(response.body().asInputStream(), Errorresponse.class);
		
		
		   return new ExcectionCustom(eerrRes.getErrorResponse(),eerrRes.getErrorCode(),response.status());
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
		 throw  new ExcectionCustom("internal server error","INTERNAL_SERVER_ERROR",500);
		   
		}
	}

}
