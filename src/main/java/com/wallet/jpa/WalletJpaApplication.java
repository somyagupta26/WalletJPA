package com.wallet.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.wallet.jpa.controller","com.wallet.jpa.service"})
@EntityScan("com.wallet.jpa.entity")
@EnableJpaRepositories("com.wallet.jpa.repository")

@SpringBootApplication
public class WalletJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletJpaApplication.class, args);
	}

}
