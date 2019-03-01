package com.example.util;

import java.io.IOException;

import com.example.coinstack.Testnet;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;

public class CoinStackUtil {

	public static double getBalance(String address) throws IOException, CoinStackException {
		CoinStackClient client = Testnet.createNewClient();

		long balance = client.getBalance(address); // 1 BTC == 100,000,000 satoshi
		double result = balance / 10000000.0;

		return result;
	}
}
