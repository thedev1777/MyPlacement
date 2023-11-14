package com.Career.ApnaPlacement.JobModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Job_Details")
public class JobDetails {
	
	@Id
	private String job_Id;
	
	@Column(name="user_id")
	private String userId;
	
	private String job_Role;
	private String job_desc;
	private String job_Link;
	private String job_Hr_Details;
	private String job_Experience;
	//private String job_Salary;
	private String job_Skills;
	private String job_Company_Name;
	private String job_Location;
	private String job_crtDtime;
	private String job_uptDtime;
	private String job_DelYn;
	
	
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getJob_Role() {
		return job_Role;
	}

	public void setJob_Role(String job_Role) {
		this.job_Role = job_Role;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public String getJob_Link() {
		return job_Link;
	}

	public void setJob_Link(String job_Link) {
		this.job_Link = job_Link;
	}

	public String getJob_Hr_Details() {
		return job_Hr_Details;
	}

	public void setJob_Hr_Details(String job_Hr_Details) {
		this.job_Hr_Details = job_Hr_Details;
	}

	public String getJob_Experience() {
		return job_Experience;
	}

	public void setJob_Experience(String job_Experience) {
		this.job_Experience = job_Experience;
	}

//	public String getJob_Salary() {
//		return job_Salary;
//	}
//
//	public void setJob_Salary(String job_Salary) {
//		this.job_Salary = job_Salary;
//	}

	public String getJob_Skills() {
		return job_Skills;
	}

	public void setJob_Skills(String job_Skills) {
		this.job_Skills = job_Skills;
	}

	public String getJob_Company_Name() {
		return job_Company_Name;
	}

	public void setJob_Company_Name(String job_Company_Name) {
		this.job_Company_Name = job_Company_Name;
	}

	public String getJob_Location() {
		return job_Location;
	}

	public void setJob_Location(String job_Location) {
		this.job_Location = job_Location;
	}

	public String getJob_crtDtime() {
		return job_crtDtime;
	}

	public void setJob_crtDtime(String job_crtDtime) {
		this.job_crtDtime = job_crtDtime;
	}

	public String getJob_uptDtime() {
		return job_uptDtime;
	}

	public void setJob_uptDtime(String job_uptDtime) {
		this.job_uptDtime = job_uptDtime;
	}

	public String getJob_DelYn() {
		return job_DelYn;
	}

	public void setJob_DelYn(String job_DelYn) {
		this.job_DelYn = job_DelYn;
	}

	public String getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(String job_Id) {
		this.job_Id = job_Id;
	}
	
	
	

}
