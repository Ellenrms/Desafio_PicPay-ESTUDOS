package com.ellenmateus.service;

import org.springframework.stereotype.Service;

import com.ellenmateus.client.AuthorizationClient;
import com.ellenmateus.entity.Transfer;
import com.ellenmateus.exception.PicPayException;

@Service
public class AuthorizationService {

	private final AuthorizationClient authorizationClient;

	public AuthorizationService(AuthorizationClient authorizationClient) {
		this.authorizationClient = authorizationClient;
	}

	public boolean isAuthorized(Transfer transfer) {
			var resp = authorizationClient.isAutorized();
			
			if (resp.getStatusCode().isError()) {
				throw new PicPayException();
		}
			
			return resp.getBody().authorized();
		}
}
