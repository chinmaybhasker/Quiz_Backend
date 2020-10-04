package com.example.Credicxo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Credicxo.modal.LoginData;
import com.example.Credicxo.modal.PerformaceEntity;
import com.example.Credicxo.modal.PerformanceModal;
import com.example.Credicxo.modal.QuestionEntity;
import com.example.Credicxo.modal.SignUpData;
import com.example.Credicxo.reporistory.QuestionRepository;
import com.example.Credicxo.reporistory.SignUpdataRepository;
import com.example.Credicxo.reporistory.performanceRepository;
import com.example.Credicxo.service.MainService;



@Controller
@CrossOrigin("*")
public class MainController {
	
	
	@Autowired
	SignUpdataRepository  signUpdataRepository;
	
	@Autowired
	QuestionRepository  questionRepository;
	
	@Autowired
	MainService service1;
	
	@Autowired
	performanceRepository performance;
	
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public  ResponseEntity addNewUser (@RequestBody  SignUpData s) {
		 try {
			SignUpData n = new SignUpData();
		    BeanUtils.copyProperties(s, n);
			signUpdataRepository.save(n);
			return ResponseEntity.ok(HttpStatus.OK);
		 }
		 catch(Exception IllegalArgumentException) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		 }
	 }

	
	 @PostMapping(path="/login" )
		public @ResponseBody Map<String, String> getLoginUser( @RequestBody  LoginData loginData) {
		// This returns a JSON or XML with the users
	 	LoginData l1 = new LoginData();
	 	BeanUtils.copyProperties(loginData, l1);
	 	Map<String, String> map = service1.checkUserDetail(l1);
		return map;
	 }
	 List<Integer> l = new ArrayList<>();
	 @GetMapping(path="/getHotelDetails") // Map ONLY POST Requests
		public  ResponseEntity<?> getQuestion (@RequestParam String number) {
			 try {
				
				 if (l.size() == 6) {
					 l.clear();
				 }
				 double x = Math.random()*(6)+1;
				 System.out.println("AAAA   "+x);
				 System.out.println(Arrays.toString(l.toArray()));
				 while (l.contains((int)x) ) {
					  x = (Math.random()*((6-1)+1))+1;
					  System.out.println("BBBB   "+x);
				 }
				 l.add((int)x);
				 QuestionEntity obj = questionRepository.findById((int)x).get();
				 
				 Map<String,QuestionEntity> map = new HashMap();
				 
				 map.put("response", obj);
				return new  ResponseEntity<>(map,HttpStatus.OK);
			 }
			 catch(Exception IllegalArgumentException) {
				return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			 }
		 }
	 
	 @PostMapping(path="/addResult" )
		public ResponseEntity<?> getLoginUser( @RequestBody  PerformanceModal obj) {
		 
		 PerformaceEntity objtemp = performance.findByEmailaddress(obj.getEmailaddress());
		 if (objtemp == null)
			 objtemp = new PerformaceEntity();
		 objtemp.setEmailaddress(obj.getEmailaddress());
		 if (obj.getPercentage().contains(".")) {
			 System.out.println(obj.getPercentage());
			 String[] temp = obj.getPercentage().split("\\.");
			 System.out.println((temp.length));
			 objtemp.setPercentage(Integer.parseInt(temp[0]));
		 }
		 else {
		 objtemp.setPercentage(Integer.parseInt(obj.getPercentage()));
		 }
		 performance.save(objtemp); 	
		 List<PerformaceEntity> list = performance.foo();
		return new ResponseEntity<>(list,HttpStatus.OK);
	 }
	 
	 @GetMapping(path="/BestPerformer") // Map ONLY POST Requests
		public  ResponseEntity<?> getBestPerformer () {
			 try {
				 System.out.println();
				 List<PerformaceEntity> list = performance.foo();
					return new ResponseEntity<>(list,HttpStatus.OK);
			 }
			 catch(Exception IllegalArgumentException) {
				return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			 }
		 }
}
