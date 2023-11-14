package com.Career.ApnaPlacement.JobDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Career.ApnaPlacement.JobModel.JobDetails;

import jakarta.transaction.Transactional;



@Repository
@EnableJpaRepositories
public interface JobRepository extends JpaRepository<JobDetails,String> {
	
	@Modifying 
	@Transactional
	@Query(value = "insert into AP_Portal.Job_Details(job_Id, user_Id, job_Role, job_desc, job_Link, job_Hr_Details, job_Experience, job_Skills, job_Company_Name, job_Location, job_crtDtime, job_uptDtime, job_DelYn\n"
			+ ")Values(:#{#job.job_Id}, :#{#job.userId}, :#{#job.job_Role}, :#{#job.job_desc}, :#{#job.job_Link}, :#{#job.job_Hr_Details},"
			+ ":#{#job.job_Experience}, :#{#job.job_Skills}, :#{#job.job_Company_Name}, :#{#job.job_Location}, now(),now(),:#{#job.job_DelYn})",nativeQuery=true)
	int insertJbDetails(@Param("job") JobDetails job);

	
	@Query(value="select CONCAT('J', YEAR(CURRENT_DATE), LPAD(IFNULL(MAX(CAST(SUBSTRING(job_Id, 6) AS SIGNED)), 0) + 1, 4, '0')) as job_Id\n"
			+ "FROM AP_Portal.Job_Details\n"
			+ "WHERE job_Id LIKE CONCAT('J', YEAR(CURRENT_DATE), '%');",nativeQuery=true)
	String getUSerId();

	
	@Modifying
	@Transactional
	@Query(value="UPDATE AP_Portal.Job_Details\n"
			+ "SET\n"
			+ "  job_Role = :#{#job.job_Role},\n"
			+ "  job_desc = :#{#job.job_desc},\n"
			+ "  job_Link = :#{#job.job_Link},\n"
			+ "  job_Hr_Details = :#{#job.job_Hr_Details},\n"
			+ "  job_Experience = :#{#job.job_Experience},\n"
			+ "  job_Skills = :#{#job.job_Skills},\n"
			+ "  job_Company_Name = :#{#job.job_Company_Name},\n"
			+ "  job_Location = :#{#job.job_Location},\n"
			+ "  job_uptDtime = NOW(),\n"
			+ "  job_DelYn = :#{#job.job_DelYn}\n"
			+ "WHERE\n"
			+ "  job_Id = :#{#job.job_Id}\n"
			+ "  AND user_Id = :#{#job.userId}\n"
			+ "",nativeQuery=true)
	int updateJobDetails(@Param("job") JobDetails job);


	@Modifying
	@Transactional
	@Query(value="delete from AP_Portal.Job_Details\n"
			+ "where \n"
			+ "job_Id=:#{#job.job_Id}\n"
			+ "and user_Id=:#{#job.userId}",nativeQuery=true)
	int deleteJobDetails(@Param("job")JobDetails job);


	@Query(value="SELECT\n"
	        + "job_Id, user_Id, job_Role, job_desc, job_Link, job_Hr_Details, job_Experience, job_Skills, job_Company_Name, job_Location, job_crtDtime as job_crt_dtime, job_uptDtime as job_upt_dtime, job_DelYn as job_del_Yn \n"
	        + "FROM AP_Portal.Job_Details\n"
	        + "WHERE\n"
	        + "(CASE WHEN :#{#job.job_Experience} = '' THEN '' ELSE job_Experience END) = :#{#job.job_Experience}\n"
	        + "AND (CASE WHEN :#{#job.job_Skills} = '' THEN '' ELSE job_Skills END) = :#{#job.job_Skills}\n"
	        + "AND (CASE WHEN :#{#job.job_Company_Name} = '' THEN '' ELSE job_Company_Name END) = :#{#job.job_Company_Name}\n"
	        + "AND (CASE WHEN :#{#job.job_Location} = '' THEN '' ELSE job_Location END) = :#{#job.job_Location}\n"
	        + "AND job_DelYn='N'",nativeQuery=true)
	List<JobDetails> selectFullJobList(@Param("job") JobDetails req);


	@Query(value="select\n"
			+ "job_Id, user_Id, job_Role, job_desc, job_Link, job_Hr_Details, job_Experience, job_Skills, job_Company_Name, job_Location, job_crtDtime as job_crt_dtime, job_uptDtime as job_upt_dtime, job_DelYn as job_del_Yn\n"
			+ "from AP_Portal.Job_Details\n"
			+ "where\n"
			+ "user_Id=:userId\n"
			+ "and job_DelYn='N'",nativeQuery=true)
	List<JobDetails> selectJobListByUSerID(String userId);
	
	

}
