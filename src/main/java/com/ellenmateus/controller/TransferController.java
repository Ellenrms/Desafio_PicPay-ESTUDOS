package com.ellenmateus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ellenmateus.DTO.DTOTransfer;
import com.ellenmateus.entity.Transfer;
import com.ellenmateus.service.TransferService;

import jakarta.validation.Valid;

@RestController
public class TransferController {
	
	 private final TransferService transferService;
	 
	 public TransferController(TransferService transferService) {
		 this.transferService = transferService;
		 
	 }
	 
	 
	 @PostMapping("/transfer")
	 public ResponseEntity<Transfer> transfer(@RequestBody @Valid DTOTransfer dto){
		 
		 var resp = transferService.transfer(dto);
		 
		 return ResponseEntity.ok(resp);
		 
		 
		 
	 }

}
