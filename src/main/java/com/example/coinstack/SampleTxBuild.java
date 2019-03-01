package com.example.coinstack;

import java.io.IOException;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.Math;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.TransactionUtil;
import io.blocko.coinstack.exception.CoinStackException;

public class SampleTxBuild {
	
	public static void sampleSendSimpleTx(CoinStackClient client, String privateKeyWIF, String receiverAddress, String amountBTC)
			throws IOException, CoinStackException {
		// txbuilder instance
		TransactionBuilder txBuilder = new TransactionBuilder();
		txBuilder.allowDustyOutput(true);
		txBuilder.shuffleOutputs(false);
		
		// set fee
		txBuilder.setFee(Math.convertToSatoshi("0.0001"));
		
		// add output
		long amount = Math.convertToSatoshi(amountBTC);
		txBuilder.addOutput(receiverAddress, amount);
		
		// build tx
		String rawTx = txBuilder.buildTransaction(client, privateKeyWIF);
		String txId = TransactionUtil.getTransactionHash(rawTx);
		
		// send tx
		client.sendTransaction(rawTx);
		System.out.printf("- sendTx: txId=%s, receiverAddr=%s, amountBTC=%s\n",
				txId, receiverAddress, amountBTC);
	}
	
}