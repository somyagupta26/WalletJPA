package com.wallet.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.wallet.jpa.entity.Wallet;

@Repository

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
	
	
	Integer findWalletBalanceById(Integer id);
	Wallet findWalletById(Integer id);
	

	
	

}
