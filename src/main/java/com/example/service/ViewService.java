package com.example.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.util.CoinStackUtil;

import io.blocko.coinstack.exception.CoinStackException;

@Service
public class ViewService {

	public double getBalance(String address) throws IOException, CoinStackException {
		return CoinStackUtil.getBalance(address);
	}
}
