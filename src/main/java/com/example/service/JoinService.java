package com.example.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.model.Users;

import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.exception.CoinStackException;

@Service
public class JoinService {

	public Users joinAddress() throws IOException, CoinStackException {
        
		String privateKey = ECKey.createNewPrivateKey();
		String address = ECKey.deriveAddress(privateKey);
		
		Users users = new Users();
		users.setPrivateKey(privateKey);
		users.setAddress(address);
		
		return users;
	}
}
