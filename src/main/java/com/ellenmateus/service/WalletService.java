package com.ellenmateus.service;

import org.springframework.stereotype.Service;

import com.ellenmateus.DTO.DTOWallet;
import com.ellenmateus.entity.Wallet;
import com.ellenmateus.exception.WalletDataAlreadyExistsException;
import com.ellenmateus.repository.WalletRepository;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(DTOWallet dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}