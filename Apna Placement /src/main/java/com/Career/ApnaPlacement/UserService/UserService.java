package com.Career.ApnaPlacement.UserService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Career.ApnaPlacement.UserDao.UserRepository;
import com.Career.ApnaPlacement.UserModel.UserDetails;

@Service
public class UserService {
	
	@Autowired
	UserRepository userDao;

	public ResponseEntity<Object> userLogin(UserDetails req) {
		
		HashMap<Object,String> Response = new HashMap<Object,String>();
		String message = "";
		String sucsess="false";
		String status = "";
		
		System.out.println("Service"+req.getUserId());
		req.setUserId(req.getUserId());
		req.setPassword(req.getPassword());
		UserDetails user = userDao.selectUserInfo(req.getUserId(),req.getPassword());
		
		System.out.println(user.getUserId()+"\n"+user.getLoginCount()+"\n"+req.getPassword());
	
		if(user.getUserId().equals(req.getUserId()) && user.getPassword().equals(req.getPassword())) {
			message = "User Sucessfully Login";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "User UnSucessfully Login";
			sucsess = "false";
			status = "500";
		}
		
		Response.put("message", message);
		Response.put("sucsess", sucsess);
		Response.put("status", status);
		
		
		return new ResponseEntity<Object>(Response,HttpStatus.OK);
	}

	public ResponseEntity<Object> userSignUp(UserDetails req) {
		
		HashMap<Object,String> Response = new HashMap<Object,String>();
		String message = "";
		String sucsess="false";
		String status = "";
		
		System.out.println("Service"+req.getUserId());
		req.setUserId(req.getUserId());
		req.setPassword(req.getPassword());
		req.setUser_Active("Y");
		req.setUser_Email(req.getUser_Email());
		req.setUser_First_Name(req.getUser_First_Name());
		req.setUser_Last_Name(req.getUser_Last_Name());
		req.setUser_Type("Admin");
		req.setUser_Mobile(req.getUser_Mobile());
		            
		int row = userDao.insertUserDetails(req);
		
	
		if(row>0) {
			message = "User Sucessfully SignUp";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "User UnSucessfully SignUp";
			sucsess = "false";
			status = "500";
		}
		
		Response.put("message", message);
		Response.put("sucsess", sucsess);
		Response.put("status", status);
		
		
		return new ResponseEntity<Object>(Response,HttpStatus.OK);
	}

}
