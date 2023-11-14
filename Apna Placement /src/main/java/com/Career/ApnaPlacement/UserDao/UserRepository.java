package com.Career.ApnaPlacement.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Career.ApnaPlacement.UserModel.UserDetails;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,String>{


	@Query(value = "select user_id,login_password,login_fail_count,User_Type,User_First_Name,User_Last_Name,User_Active,User_Mobile ,User_Crt_Dtime,User_Upt_Dtime,user_email from AP_Portal.User_Login where user_id =:userId and login_password =:password Limit 1",nativeQuery=true) 
	UserDetails selectUserInfo(String userId, String password);

	
	@Modifying 
	@Query(value = "INSERT INTO AP_Portal.User_Login (user_id, login_password, login_fail_count, User_Type, User_First_Name, User_Last_Name, User_Active, User_Mobile, User_Email, User_Crt_Dtime, User_Upt_Dtime)"
	        + " VALUES (:#{#user.userId}, :#{#user.password}, 0, :#{#user.User_Type}, :#{#user.User_First_Name}, :#{#user.User_Last_Name}, :#{#user.User_Active}, :#{#user.User_Mobile}, :#{#user.User_Email}, NOW(), NOW())", nativeQuery = true)
	@Transactional //for insert update delete operation need to use this annotation
	int insertUserDetails(@Param("user") UserDetails user);

   
	
	

}
