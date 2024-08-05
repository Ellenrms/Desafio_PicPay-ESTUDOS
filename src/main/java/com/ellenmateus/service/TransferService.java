package com.ellenmateus.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.ellenmateus.DTO.DTOTransfer;
import com.ellenmateus.entity.Transfer;
import com.ellenmateus.entity.Wallet;
import com.ellenmateus.exception.InsufficientBalanceException;
import com.ellenmateus.exception.TransferNotAllowedForWalletTypeException;
import com.ellenmateus.exception.TransferNotAuthorizedException;
import com.ellenmateus.exception.WalletNotFoundException;
import com.ellenmateus.repository.TransferRepository;
import com.ellenmateus.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferService {

	private final TransferRepository transferRepository;
	private final AuthorizationService authorizationService;
	private final NotificationService notificationService;
	private final WalletRepository walletRepository;

	public TransferService(TransferRepository transferRepository,
						   AuthorizationService authorizationService,
						   NotificationService notificationService,
						   WalletRepository walletRepository) {
		this.transferRepository = transferRepository;
		this.authorizationService = authorizationService;
		this.notificationService = notificationService;
		this.walletRepository = walletRepository;
	}

	@Transactional
	public Transfer transfer(DTOTransfer DTOTransfer) {
		
		 var sender = walletRepository.findById(DTOTransfer.payer())
	                .orElseThrow(() -> new WalletNotFoundException(DTOTransfer.payer()));

	        var receiver = walletRepository.findById(DTOTransfer.payee())
	                .orElseThrow(() -> new WalletNotFoundException(DTOTransfer.payee()));

	        validateTransfer(DTOTransfer, sender);

	        sender.debit(DTOTransfer.value());
	        receiver.credit(DTOTransfer.value());

	        var transfer = new Transfer(sender, receiver, DTOTransfer.value());

	        walletRepository.save(sender);
	        walletRepository.save(receiver);
	        var transferResult = transferRepository.save(transfer);

	        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

	        return transferResult;
	    }
	

    private void validateTransfer(DTOTransfer dtoTransfer, Wallet sender) {

        if (!sender.isTransferAllowedForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if (!sender.isBalancerEqualOrGreatherThan(dtoTransfer.value())) {
            throw new InsufficientBalanceException();
        }

        if (!authorizationService.isAuthorized(dtoTransfer)) {
            throw new TransferNotAuthorizedException();
        }

    }
}

