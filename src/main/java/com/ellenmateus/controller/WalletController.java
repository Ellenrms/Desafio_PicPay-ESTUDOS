package com.ellenmateus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ellenmateus.DTO.DTOWallet;
import com.ellenmateus.entity.Wallet;
import com.ellenmateus.service.WalletService;

import jakarta.validation.Valid;

@RestController
public class WalletController {

	private final WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;

	}

	@PostMapping("/wallets")
	public ResponseEntity<Wallet> createWallet(@RequestBody @Valid DTOWallet dto) {

		var wallet = walletService.createWallet(dto);

		return ResponseEntity.ok(wallet);

	}
}
