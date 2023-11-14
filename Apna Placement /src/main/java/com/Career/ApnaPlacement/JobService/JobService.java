package com.Career.ApnaPlacement.JobService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Career.ApnaPlacement.JobDao.JobRepository;
import com.Career.ApnaPlacement.JobModel.JobDetails;

@Service
public class JobService {

	@Autowired
	JobRepository jobDao;
	
	public ResponseEntity<Object> insertJob(JobDetails req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		String message = "";
		String sucsess="false";
		String status = "";
		int row=0;
		
		String userId = jobDao.getUSerId();
		
		req.setJob_Id(userId);
		System.out.println("JobId--"+userId);
		
		req.setJob_Company_Name(req.getJob_Company_Name());
		req.setJob_DelYn("N");
		req.setJob_desc(req.getJob_desc());
		req.setJob_Experience(req.getJob_Experience());
		req.setJob_Hr_Details(req.getJob_Hr_Details());
		req.setJob_Link(req.getJob_Link());
		req.setJob_Location(req.getJob_Location());
		req.setJob_Role(req.getJob_Role());
	//	req.setJob_Salary(req.getJob_Salary());
		req.setUserId(req.getUserId());
		
		row = jobDao.insertJbDetails(req);
		
		if(row>0) {
			message = "Job Added Sucessfully";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "Job Added UnSucessfully";
			sucsess = "false";
			status = "500";
		}
		
		map.put("message", message);
		map.put("sucsess", sucsess);
		map.put("status", status);
		
		
		return new ResponseEntity<Object>(map,HttpStatus.OK);
		
	}
	

	public ResponseEntity<Object> updateJob(JobDetails req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		String message = "";
		String sucsess="false";
		String status = "";
		int row=0;
		
		
		req.setJob_Company_Name(req.getJob_Company_Name());
		req.setJob_DelYn("N");
		req.setJob_desc(req.getJob_desc());
		req.setJob_Experience(req.getJob_Experience());
		req.setJob_Hr_Details(req.getJob_Hr_Details());
		req.setJob_Link(req.getJob_Link());
		req.setJob_Location(req.getJob_Location());
		req.setJob_Role(req.getJob_Role());
	//	req.setJob_Salary(req.getJob_Salary());
		req.setUserId(req.getUserId());
		req.setJob_Id(req.getJob_Id());
		
		row = jobDao.updateJobDetails(req);
		
		if(row>0) {
			message = "Job Updated Sucessfully";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "Job Updated UnSucessfully";
			sucsess = "false";
			status = "500";
		}
		
		map.put("message", message);
		map.put("sucsess", sucsess);
		map.put("status", status);
		
		
		return new ResponseEntity<Object>(map,HttpStatus.OK);
		
	}


	public ResponseEntity<Object> deleteJob(JobDetails req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		String message = "";
		String sucsess="false";
		String status = "";
		int row=0;
		
		req.setUserId(req.getUserId());
		req.setJob_Id(req.getJob_Id());
		
		row = jobDao.deleteJobDetails(req);
		
		if(row>0) {
			message = "Job Deleted Sucessfully";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "Job Deleted UnSucessfully";
			sucsess = "false";
			status = "500";
		}
		
		map.put("message", message);
		map.put("sucsess", sucsess);
		map.put("status", status);
		
		
		return new ResponseEntity<Object>(map,HttpStatus.OK);
		
	}


	public ResponseEntity<Object> selectAllJobList(JobDetails req) {
		LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
		String message = "";
		String sucsess="false";
		String status = "";
		
		List<JobDetails> user = jobDao.selectFullJobList(req);
		
		if(user != null || user.size() > 0) {
			message = "Job List Found Sucessfully";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "Job List Found UnSucessfully";
			sucsess = "false";
			status = "500";
		}
		
		map.put("Job List", user);
		map.put("message", message);
		map.put("sucsess", sucsess);
		map.put("status", status);
		
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	}


	public ResponseEntity<Object> selectJobListByUser(JobDetails req) {
		LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
		String message = "";
		String sucsess="false";
		String status = "";
		
		List<JobDetails> user = jobDao.selectJobListByUSerID(req.getUserId());
		
		if(user != null || user.size() > 0) {
			message = "Job List Found Sucessfully";
			sucsess = "true";
			status = "200";
			
		}else {
			message = "Job List Found UnSucessfully";
			sucsess = "false";
			status = "500";
		}
		
		map.put("Job List", user);
		map.put("message", message);
		map.put("sucsess", sucsess);
		map.put("status", status);
		
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	}

}
