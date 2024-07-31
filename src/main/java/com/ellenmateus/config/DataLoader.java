package com.ellenmateus.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ellenmateus.entity.WalletType;
import com.ellenmateus.repository.WalletTypeRepository;

@Configuration
public class DataLoader implements CommandLineRunner {
	
	private final WalletTypeRepository walletTypeRepository;
	
	public DataLoader(WalletTypeRepository walletTypeRepository) {
		this.walletTypeRepository = walletTypeRepository;
	}
	
	public void run(String... args)throws Exception{
		Arrays.stream(WalletType.Enum.values())
		.forEach(walletType -> walletTypeRepository.save(walletType.get()));
		
		
		
	}

}
