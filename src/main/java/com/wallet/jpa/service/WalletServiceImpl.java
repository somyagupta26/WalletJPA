package com.wallet.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.jpa.entity.Wallet;
import com.wallet.jpa.exception.WalletException;
import com.wallet.jpa.repository.WalletRepository;
@Service
public class WalletServiceImpl implements WalletService {
 
	@Autowired
	WalletRepository walletrepo;
	@Override
	public Wallet createWallet(Wallet wallet)  {
		return this.walletrepo.save(wallet);
		
	}

	@Override
	public String addBalance(int id, double amount)  {
		// TODO Auto-generated method stub
		Wallet wallet =walletrepo.findWalletById(id);
		Double currentBalance=wallet.getBalance();
		Double total=currentBalance+amount;
				wallet.setBalance(currentBalance+amount);
		walletrepo.save(wallet);
		return "The wallet was updated with balance"+total+" walletID"+id;
		
		
		
	}

	@Override
	public String withdraw(int id, double amount)  {
		// TODO Auto-generated method stub
		Wallet wallet =walletrepo.findWalletById(id);
		Double currentBalance=wallet.getBalance();
		if(amount>currentBalance)
		{
			return "the wallet have unsufficient amount";
		}
		Double total=currentBalance-amount;
				wallet.setBalance(currentBalance-amount);
		walletrepo.save(wallet);
		return "The wallet was updated with balance"+total+" walletID"+id;
	}

	@Override
	public Wallet updateName(int id, String firstname, String lastname)  {
		Wallet wallet =walletrepo.findWalletById(id);
		wallet.setFirstname(firstname);
		wallet.setLastname(lastname);
		return wallet;}

	@Override
	public String deleteWallet(int id) {
		// TODO Auto-generated method stub
		Optional<Wallet> department=walletrepo.findById(id);		
		if(department.isEmpty())
		{
			return "The wallet was not present with walletId "+id+" hence deletion is not possible";
		}
		walletrepo.deleteById(id);
		return "Wallet was deleted from database successfully for walletId: "+id;
	}

	@Override
	public Wallet getWallet(int id) {
		// TODO Auto-generated method stub
		Optional<Wallet> optWal = this.walletrepo.findById(id);

		if (optWal.isPresent())
			return optWal.get();

		return null;
	}

	@Override
	public List<Wallet> getAllWallets() {
		// TODO Auto-generated method stub
		
		return this.walletrepo.findAll();
	}

	@Override
	public List<Wallet> tranferAmount(int fromId, int toId, double amount) {
		// TODO Auto-generated method stub
		Wallet fromWallet=walletrepo.findWalletById(fromId);
		Double availableBalance=fromWallet.getBalance();
		Wallet toWallet=walletrepo.findWalletById(toId);
		if(availableBalance>=amount)
		{
			
			Double availableBalanceTo=toWallet.getBalance();
			fromWallet.setBalance(availableBalanceTo+amount);
			toWallet.setBalance(availableBalance-amount);
			walletrepo.save(fromWallet);
			walletrepo.save(toWallet);
			List<Wallet> wallets=new ArrayList<Wallet>();
			wallets.add(fromWallet);
			wallets.add(toWallet);
			return wallets;
			
		}
		List<Wallet> wallets=new ArrayList<Wallet>();
		wallets.add(fromWallet);
		wallets.add(toWallet);
		return wallets;
		
	}

}
