package com.example.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Users;
import com.example.service.JoinService;
import com.example.service.ViewService;

import io.blocko.coinstack.exception.CoinStackException;

@RestController
@RequestMapping(value = "address")
public class UsersController {
	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private ViewService viewService;

	@GetMapping("/join")
	public @ResponseBody Users joinRequest() throws IOException, CoinStackException {
		return joinService.joinAddress();
	}
	
	@GetMapping("/balance")
	public double getBalanceRequest(@RequestParam Map<String, String> paramMap) throws IOException, CoinStackException {
		String address = paramMap.get("address");
		if(address == null || address.equals("")) {
			return -1;
		}
		return viewService.getBalance(address);
	}
	
}
