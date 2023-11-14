package com.Career.ApnaPlacement.JobController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Career.ApnaPlacement.JobModel.JobDetails;
import com.Career.ApnaPlacement.JobService.JobService;
import com.Career.ApnaPlacement.UserModel.UserDetails;

@RestController
@RequestMapping(value="/Job")
public class JobController {

	@Autowired
	JobService jobservice;
	
	@RequestMapping(value = "/insertJob" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> insertJob(@RequestBody JobDetails req){
		System.out.println("Controller");
	return jobservice.insertJob(req);
		
	}
	
	@RequestMapping(value = "/updateJob" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> updateJob(@RequestBody JobDetails req){
		System.out.println("Controller");
	return jobservice.updateJob(req);
	}
	
	@RequestMapping(value = "/deleteJob" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> deleteJob(@RequestBody JobDetails req){
		System.out.println("Controller");
	return jobservice.deleteJob(req);	
	}
	
	@RequestMapping(value = "/selectAllJobList" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> selectAllJobList(@RequestBody JobDetails req){
		System.out.println("Controller");
	return jobservice.selectAllJobList(req);	
	}
	
	@RequestMapping(value = "/selectJobListByUser" ,method = RequestMethod.POST, produces = "application/json;charset=UTF-8")  
    public ResponseEntity<Object> selectJobListByUser(@RequestBody JobDetails req){
		System.out.println("Controller");
	return jobservice.selectJobListByUser(req);	
	}
    
}
