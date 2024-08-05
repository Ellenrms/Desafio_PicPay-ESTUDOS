package com.ellenmateus.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ellenmateus.entity.Transfer;

public interface TransferRepository  extends JpaRepository <Transfer, UUID>{

}
