package com.example.controller;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.TxService;
import io.blocko.coinstack.exception.CoinStackException;

@RestController
@RequestMapping(value = "/tx")
public class TransactionController {

	@Autowired
	private TxService txService;
	
	@GetMapping("/simple")
	public int sendSimpleTxRequest(@RequestParam Map<String, String> paramMap) throws IOException, CoinStackException {
		String privateKey = paramMap.get("privateKey");
		String from = paramMap.get("from");
		String to = paramMap.get("to");
		String value = paramMap.get("value");
		
		return txService.sendTx(privateKey, from, to, value);
	}
}
