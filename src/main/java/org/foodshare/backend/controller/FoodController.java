package org.foodshare.backend.controller;

import org.foodshare.backend.entity.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FoodController {
	
	@PostMapping("/hello")
	public ResponseEntity<String> sayHello(@RequestBody Test test){
		System.out.println(test.getId()+"ahsdsdahhasdkdas");
		return new ResponseEntity<String>(test.getEmail(),HttpStatus.OK);
	}

}
