package com.cybage.services;

import java.sql.Date;
import java.util.List;

import com.cybage.dao.ManagerDaoI;
import com.cybage.dao.ManagerDaoImpl;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Users;

public class ManagerServiceImpl implements ManagerServiceI{

	ManagerDaoI manager=new ManagerDaoImpl();
	
	//code for date manipulation
	public java.sql.Date getDate(String date) {
		
	
		return Date.valueOf(date);  
	}
///////////////Service for Sports Table CRUD
	//Adding sports into SportsTable
	public int addSport(String sportName) throws Exception {
		
		return manager.addSports(sportName);
	}
	

	
	public int removeSport(String sportName) throws Exception {
		return manager.removeSports(sportName);
	}
	
	
	/////////////////////////////////////////////
	
	//adding record into Batch table
	public int addBatch(Batch batch) throws Exception {
		
		return manager.addBatch(batch);
	}

	//removing record from Batch table
	public int removeBatch(int batchId) throws Exception {
		return manager.removeBatch(batchId);
	}
	
	public Batch getBatch(int batchId) throws Exception{
		return manager.getBatch(batchId);
	}

	//updating record from Batch table
	public int updateBatch(Batch batch) throws Exception {
		
		return manager.updateBatch(batch);
	}


	public List<AllBatchInfo> getAllBatches() throws Exception {
		return manager.getAllBatches();
	
	}
	
	public Users getManager(String username) throws Exception {
		
		return manager.getManager(username);
	}

	
	
	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception 
	{
		return manager.getAllEnrolledMembers();
	}
	
	
	public int approveEnrollment(Enrollment enrlmnt)throws Exception
	{
		return manager.approveEnrollment(enrlmnt);
	}
	
	public int rejectEnrollment(Enrollment enrlmnt)throws Exception 
	{
		return manager.rejectEnrollment(enrlmnt);
	}
	
	public int updateBatchSize(int enrollId,int batchSize)throws Exception
	{
		return manager.updateBatchSize(enrollId, batchSize);
	}
	
	
	//Service methods for Plans CRUD
	@Override	
	public int addPlan(Plans plan) throws Exception {

		return manager.addPlan(plan);
	}
	@Override
	public int removePlan(int planId) throws Exception {

		return manager.removePlan(planId);
	}
	@Override
	public int updatePlan(Plans plan) throws Exception {

		return manager.updatePlan(plan);
	}
	@Override
	public List<Plans> getAllPlans() throws Exception {

		return manager.getAllPlans();
	}
	@Override
	public Plans getPlan(int planId) throws Exception {

		return manager.getPlan(planId);
	}
	
	@Override
	public Plans getPlanByName(String planName) throws Exception {
		
		return manager.getPlanByName(planName);
	}
	
}
