package com.wallet.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.wallet.jpa.entity.Wallet;
import com.wallet.jpa.service.WalletService;


@RestController

public class WalletController {
	@Autowired
    private WalletService walletService;

	@PostMapping("wallet")
	public Wallet addWallet(@RequestBody Wallet wallet) {

		
			return this.walletService.createWallet(wallet);
		

	}

	@GetMapping("wallet/{id}")
	public Wallet getWalletById(@PathVariable("id") Integer walletId) {

		return this.walletService.getWallet(walletId);

	}
	@PutMapping("wallet/add/{id}/{balance}")
	public String addbalance(@PathVariable Integer id,@PathVariable  Double balance) {

		return this.walletService.addBalance(id, balance);

	}
	@PutMapping("wallet/withdraw/{id}/{balance}")
	public String withdrawbalance(@PathVariable Integer id,@PathVariable  Double balance) {

		return this.walletService.withdraw(id, balance);

	}
	@PutMapping("wallet/name/{id}/{firstname}/{lastname}")
	public Wallet updateName(@PathVariable Integer id,@PathVariable String firstname,@PathVariable String lastname)
	{
		
		return this.walletService.updateName(id, firstname, lastname);
	}
	@GetMapping("wallet/delete/{id}")
	public String deleteWallet(@PathVariable("id") Integer id) {

		return this.walletService.deleteWallet(id);

	}
	
	@GetMapping("wallets")
	public List<Wallet> getAllWallet() {

		return this.walletService.getAllWallets();

	}

	
	@PutMapping("wallet")
	public Wallet updateWallet(@RequestBody Wallet updateWallet) {

		return this.walletService.createWallet(updateWallet);

	}
	
	
	

}
