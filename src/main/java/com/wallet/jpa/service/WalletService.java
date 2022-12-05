package com.wallet.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.jpa.entity.Wallet;
@Service
public interface WalletService {

	Wallet createWallet(Wallet wallet) ;
	String addBalance(int id, double amount) ;
	String withdraw(int id, double amount);
	Wallet updateName(int id, String firstname, String lastname);
	String deleteWallet(int id);
	Wallet getWallet(int id);
	List<Wallet> getAllWallets();
	
	List<Wallet> tranferAmount(int fromId, int toId, double amount);

}
