package com.ellenmateus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellenmateus.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
	
	Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);

}
