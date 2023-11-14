package com.Career.ApnaPlacement.UserModel;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Login")
public class UserDetails {

	@Id
	@Column(name="user_id")
	private String userId;
	@Column(name="login_password")
	private String password;
	@Column(name="login_fail_count")
	private String loginCount;
	

	private String User_Type;
	private String User_First_Name;
	private String User_Last_Name;
	private String User_Active;
	private String User_Mobile;
	private String User_Email;
	
    @CreationTimestamp
	@Column(name = "User_Crt_Dtime")
	private LocalDateTime userCrtDtime;

	@UpdateTimestamp
	@Column(name = "User_Upt_Dtime")
	private LocalDateTime userUptDtime;
	
	
	
	public LocalDateTime getUserCrtDtime() {
		return userCrtDtime;
	}
	public void setUserCrtDtime(LocalDateTime userCrtDtime) {
		this.userCrtDtime = userCrtDtime;
	}
	public LocalDateTime getUserUptDtime() {
		return userUptDtime;
	}
	public void setUserUptDtime(LocalDateTime userUptDtime) {
		this.userUptDtime = userUptDtime;
	}
	public String getUser_Type() {
		return User_Type;
	}
	public void setUser_Type(String user_Type) {
		User_Type = user_Type;
	}
	public String getUser_First_Name() {
		return User_First_Name;
	}
	public void setUser_First_Name(String user_First_Name) {
		User_First_Name = user_First_Name;
	}
	public String getUser_Last_Name() {
		return User_Last_Name;
	}
	public void setUser_Last_Name(String user_Last_Name) {
		User_Last_Name = user_Last_Name;
	}
	public String getUser_Active() {
		return User_Active;
	}
	public void setUser_Active(String user_Active) {
		User_Active = user_Active;
	}
	public String getUser_Mobile() {
		return User_Mobile;
	}
	public void setUser_Mobile(String user_Mobile) {
		User_Mobile = user_Mobile;
	}
	public String getUser_Email() {
		return User_Email;
	}
	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(String loginCount) {
		this.loginCount = loginCount;
	}

	
}
