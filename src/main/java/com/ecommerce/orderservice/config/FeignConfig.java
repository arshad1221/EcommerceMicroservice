package com.ecommerce.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.orderservice.external.decoder.CustomErrorDecoder;

import feign.Capability;
import feign.codec.ErrorDecoder;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class FeignConfig {




	@Bean
	ErrorDecoder errorDecoder() {


		return new CustomErrorDecoder();
	}
	
	@Bean
	public Capability capability(final MeterRegistry registry) {
	    return new MicrometerCapability(registry);
	}

}
