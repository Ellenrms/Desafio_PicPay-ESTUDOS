package com.ellenmateus.service;

import org.springframework.stereotype.Service;

import com.ellenmateus.DTO.DTOWallet;
import com.ellenmateus.entity.Wallet;
import com.ellenmateus.repository.WalletRepository;

@Service
public class WalletService {

	private final WalletRepository walletRepository;

	public WalletService(WalletRepository walletRepository) {
		this.walletRepository = walletRepository;
	}
	
	var walletDb = walletRepository.finfByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
	if(walletDb.isPresent()) {
		
	}
	
	public Wallet createWallet(DTOWallet dto) {
		return walletRepository.save(dto.toWallet());
		
	}
}
