package com.cybage.services;



import java.sql.Date;
import java.util.List;

import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Users;

public interface ManagerServiceI {
	
	public int addSport(String sportName) throws Exception; 
	public int removeSport(String sportName) throws Exception; 
	public Batch getBatch(int batchId) throws Exception;
	public int addBatch(Batch batch) throws Exception;
	public Date getDate(String date);
	public int removeBatch(int batchId)throws Exception;
	public int updateBatch(Batch batch) throws Exception;
	
	public List<AllBatchInfo> getAllBatches()throws Exception;
	public Users getManager(String username)throws Exception;
	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception;
	public int approveEnrollment(Enrollment enrlmnt)throws Exception;
	public int rejectEnrollment(Enrollment enrlmnt)throws Exception ;
	public int updateBatchSize(int enrollId,int batchSize)throws Exception;
	
	public List<Plans> getAllPlans()throws Exception;
	public Plans getPlan(int planId) throws Exception;
	public int addPlan(Plans plan)throws Exception;
	public int removePlan(int planId)throws Exception;
	public int updatePlan(Plans plan)throws Exception;
	public Plans getPlanByName(String planName) throws Exception;

}



