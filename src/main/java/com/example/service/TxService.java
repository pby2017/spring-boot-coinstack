package com.example.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.coinstack.SampleTxBuild;
import com.example.coinstack.Testnet;
import com.example.util.CoinStackUtil;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;

@Service
public class TxService {

	public int sendTx(String privateKey, String from, String to, String value) throws IOException, CoinStackException {
		CoinStackClient client = Testnet.createNewClient();
		
		if (CoinStackUtil.getBalance(from) < Double.parseDouble(value)) {
			return -1;
		}
		
		SampleTxBuild.sampleSendSimpleTx(client, privateKey, to, value);
		
		return 0;
	}
}
