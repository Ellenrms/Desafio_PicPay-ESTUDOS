package com.ellenmateus.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.ellenmateus.DTO.AuthorizationResponse;

@FeignClient(
		url = "${client.authorization-service.url}"
			)

public interface AuthorizationClient {
	
	@GetMapping
	ResponseEntity<AuthorizationResponse> isAutorized();
	

}
