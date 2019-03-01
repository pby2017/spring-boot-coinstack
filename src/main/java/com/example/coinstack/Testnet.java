package com.example.coinstack;

import java.security.PublicKey;

import io.blocko.coinstack.AbstractEndpoint;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.model.CredentialsProvider;

/**
 * Hello world!
 *
 */
public class Testnet {

	public static CoinStackClient createNewClient() {
		// Client °´Ã¼ »ý¼º
		CredentialsProvider credentials = null;
		AbstractEndpoint endpoint = new AbstractEndpoint() {
			@Override
			public String endpoint() {
				return "http://testchain.blocko.io";
			}

			@Override
			public boolean mainnet() {
				return true;
			}

			@Override
			public PublicKey getPublicKey() {
				return null;
			}
		};
		CoinStackClient client = new CoinStackClient(credentials, endpoint);
		return client;
	}

}
