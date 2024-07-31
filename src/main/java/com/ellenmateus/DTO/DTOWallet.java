package com.ellenmateus.DTO;

import com.ellenmateus.entity.Wallet;
import com.ellenmateus.entity.WalletType;

public record  DTOWallet (String fullName,
						  String cpfCnpj,
						  String email,
						  String password,
						  WalletType.Enum walletType) {
	
	
	public Wallet toWallet() {
		return new Wallet(
				fullName,
				cpfCnpj,
				email,
				password,
				walletType.get());
	}

}
