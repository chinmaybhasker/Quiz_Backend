package com.example.Credicxo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Credicxo.modal.LoginData;
import com.example.Credicxo.modal.SignUpData;
import com.example.Credicxo.reporistory.SignUpdataRepository;


@Service
public class MainService {
	
	// signUpdataRepository;
	@Autowired
	SignUpdataRepository  signUpdataRepository;
	
	
	boolean flag = false;
	public  Map<String, String> checkUserDetail(LoginData loginData) {
		Map<String, String> map=new HashMap<>();  
		Iterable<SignUpData> list = new ArrayList<>();
		list = signUpdataRepository.findAll();
		for (SignUpData signUpdata : list) {
			if (loginData.getEmailaddress().equals(signUpdata.getUserName())) {
				if (loginData.getPassword().equals(signUpdata.getPassword())) {
					map.put("response", "Valid User");
					map.put("Name", signUpdata.getFirstName());
					return map;
				}
			}
		}
		 map.put("response", "Invalid User");
		return map;
	}

}
