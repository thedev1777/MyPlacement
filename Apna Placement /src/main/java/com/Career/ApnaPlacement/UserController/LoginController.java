package com.Career.ApnaPlacement.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Career.ApnaPlacement.UserModel.UserDetails;
import com.Career.ApnaPlacement.UserService.UserService;

@RestController
@RequestMapping(value="/myUser")
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userLogin" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> userLogin(@RequestBody UserDetails req){
		System.out.println("Controller");
	return userService.userLogin(req);
		
	}
	
	@RequestMapping(value = "/userSignUp" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> userSignUp(@RequestBody UserDetails req){
		System.out.println("Controller");
	return userService.userSignUp(req);
		
	}
	
	
}
