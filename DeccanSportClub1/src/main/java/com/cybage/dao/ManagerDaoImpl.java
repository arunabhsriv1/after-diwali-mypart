package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.dbutil.DbUtil;
import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Users;

public class ManagerDaoImpl implements ManagerDaoI{


	public ManagerDaoImpl()
	{}

//list of batches with repective details
	public List<AllBatchInfo> getAllBatches() throws Exception {
		String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName, s.sportId ,b.planId,p.planName, p.fees, p.duration from batch b inner join Sports s on  s.sportId=b.sportId inner join plans p on b.planId=p.planId";

		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<AllBatchInfo>list=new ArrayList<AllBatchInfo>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){	

			list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10)) );

		}
		return list;	
	}


	public int addBatch(Batch batch) throws Exception {
		String sql = "insert into batch(startDate,endDate ,batchSize,sportId,planId) values(?,?,?,?,?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setDate(1, batch.getStartDate());
		ps.setDate(2, batch.getEndDate());
		ps.setInt(3, batch.getBatchSize());
		ps.setInt(4, batch.getSportId());
		ps.setInt(5, batch.getPlanId());
		//ps.setInt(5, batch.getBatchId());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
			
		}

		else {

			throw new Exception("Could not insert batch record");
		}
	}

	//

	public Batch getBatch(int batchId) throws Exception{
		String sql = "select * from batch where batchId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, batchId);
		ResultSet rs = ps.executeQuery();
		Batch  batch = null;
		if(rs.next()) {
			batch = new Batch(rs.getInt(1), rs.getDate(2),rs.getDate(3), rs.getInt(4),rs.getInt(5),rs.getInt(6));
		}
		return batch;
	}

	//to delete a record from Batch table

	public int removeBatch(int batchId) throws Exception {
		String sql = "delete from Batch where batchId= ?";
		Connection con = DbUtil.getConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);


		ps.setInt(1, batchId);		

		int rowAffected= ps.executeUpdate();
		
		if(rowAffected==1)
		{
			
			return rowAffected;
			
			
		}

		else {

			throw new Exception("Could not delete batch record");
		}
	}


	///update record in Batch table
	public int updateBatch(Batch batch) throws Exception {
		String sql = " update Batch SET startDate=? ,endDate=?,batchSize=?,sportId=?,planId=?  where batchId=?; ";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, batch.getStartDate());
		ps.setDate(2,batch.getEndDate() );
		ps.setInt(3, batch.getBatchSize());
		ps.setInt(4,batch.getSportId());
		ps.setInt(5, batch.getPlanId());
		ps.setInt(6,batch.getBatchId());


		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not update Batch tables record");
		}
	}

	////////////////////Sports table CRUD operations

	public int addSports(String sportName) throws Exception {
		String sql = "insert into Sports(sportName) values(?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, sportName);
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not insert Sports record");
		}
	}


	public int removeSports(String sportName) throws Exception {
		String sql = "delete from Sports where sportName=?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		String sportName1=sportName.toUpperCase(); 
		ps.setString(1, sportName1);
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not delete Sports record");
		}
	}



	///to fetch a record of single manager
	public Users getManager(String username) throws Exception{
		String sql = "select * from users where username=?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Users user= null;
		if(rs.next()) {
			user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
		}
		return user;
	}

	//to fetch list of enrolled members

	public List<AllBatchInfo> getAllEnrolledMembers() throws Exception {
		String sql = "select b.batchId,b.startDate,b.endDate,b.batchSize,s.sportName, s.sportId ,b.planId,p.planName, p.fees, p.duration ,e.enrollId,e.mStatus,e.username from batch b inner join Sports s on  s.sportId=b.sportId inner join plans p on b.planId=p.planId inner join enrollment e on b.batchId=e.batchId inner join users u on e.username=u.username";

		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<AllBatchInfo>list=new ArrayList<AllBatchInfo>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){		

			//System.out.println(rs.getInt("batchId")+" "+rs.getDate("startDate")+" "+rs.getDate("endDate")+" "+rs.getInt("batchSize")+" "+rs.getString("sportName"));
			list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13)) );
			//list.add(new AllBatchInfo(rs.getInt(1),rs.getDate(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6)),rs.getInt(7));

		}
		return list;	
	}

	///to update batsize after enrolling user
	public int updateBatchSize(int enrollId,int batchSize)throws Exception
	{
		String sql = "select batchId  from enrollment where enrollId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1,enrollId);
		ResultSet rs = ps.executeQuery();
		Integer batchId=null;

		if(rs.next()) 
		{
			batchId=rs.getInt(1);

		}

		String sql1="update batch set batchSize=? where batchId=?";
		Connection connection1 = DbUtil.getConnection();
		PreparedStatement ps1 = connection1.prepareStatement(sql1);
		batchSize=batchSize-1;
		ps1.setInt(1,batchSize);
		ps1.setInt(2, batchId);
		int rowAffected= ps1.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not update batch Size");
		}


	}

	public int approveEnrollment(Enrollment enrlmnt)throws Exception 
	{

		String sql = " update Enrollment SET mStatus=?  where enrollId=?; ";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "Approved");
		ps.setInt(2,enrlmnt.getEnrollId());


		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not Approve as the batch size is already full");
		}

	}

	public int rejectEnrollment(Enrollment enrlmnt)throws Exception 
	{
		String sql = " update Enrollment SET mStatus=?  where enrollId=?; ";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "Rejected");
		ps.setInt(2,enrlmnt.getEnrollId());


		int rowAffected= ps.executeUpdate();


		return rowAffected;



	}

//////////////////Plan CRUD DAO Methods
	@Override	
	public int addPlan(Plans plan) throws Exception {

		String sql = "insert into plans(planName,fees,duration) values(?,?,?)";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, plan.getPlanName());
		ps.setDouble(2, plan.getFees());
		ps.setInt(3, plan.getDuration());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not insert plan record");
		}
	}

	@Override
	public int removePlan(int planId) throws Exception {

		String sql = "delete from plans where planId= ?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);


		ps.setInt(1, planId);		

		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not delete plans record");
		}

	}

	@Override
	public int updatePlan(Plans plan) throws Exception {

		String sql = "update plans SET planName=?,fees=?,duration=? where planId=?";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, plan.getPlanName());
		ps.setDouble(2, plan.getFees());
		ps.setInt(3, plan.getDuration());

		ps.setInt(4,plan.getPlanId());
		int rowAffected= ps.executeUpdate();
		if(rowAffected==1)
		{
			return rowAffected;
		}

		else {

			throw new Exception("Could not update Plans tables record");
		}
	}

	@Override
	public List<Plans> getAllPlans() throws Exception {

		String sql = "select * from plans";
		Connection con = DbUtil.getConnection();		
		PreparedStatement ps = con.prepareStatement(sql);
		List<Plans>list=new ArrayList<Plans>();
		ResultSet rs= ps.executeQuery();
		while(rs.next()){

			list.add(new Plans(rs.getInt("planId"),rs.getString("planName"),rs.getDouble("fees"), rs.getInt("duration")));

		}
		return list;
	}

	@Override
	public Plans getPlan(int planId) throws Exception {
		String sql = "select * from plans where planId = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, planId);
		ResultSet rs = ps.executeQuery();
		Plans plan= null;
		if(rs.next()) {
			plan= new Plans(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
		}
		return plan;
	}
	
	@Override
	public Plans getPlanByName(String planName) throws Exception {
		
		String sql = "select * from plans where planName = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, planName);
		ResultSet rs = ps.executeQuery();
		Plans plan= null;
		if(rs.next()) {
			plan= new Plans(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
		}
		return plan;
		
	}

}
