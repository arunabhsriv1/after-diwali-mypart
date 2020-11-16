package com.cybage.services;

import java.util.List;
import com.cybage.dao.AdminDaoI;
import com.cybage.dao.AdminDaoImpl;
import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public class AdminServiceImpl implements AdminServiceI {
	AdminDaoI adminDaoObj = new AdminDaoImpl();

	@Override
	public List<Users> getManagers() throws Exception{
		return adminDaoObj.getAllManagers();
	}

	@Override
	public int addManager(Users user) throws Exception{
		return adminDaoObj.addManager(user);
	}

	@Override
	public int deleteManager(String username) throws Exception {
		return adminDaoObj.deleteManager(username);
	}


	@Override
	public Users getManager(String username) throws Exception {
		return adminDaoObj.getManager(username);	
	}

	@Override
	public int updateManager(Users user) throws Exception{
		return adminDaoObj.updateManager(user);		
	}

	@Override
	public List<Sports> getSports() throws Exception {
		return adminDaoObj.getAllSports();
		 
	}

	@Override
	public int addSport(Sports sports) throws Exception {
		return adminDaoObj.addSport(sports);
	}

	@Override
	public int deleteSport(String sportName) throws Exception {
		return adminDaoObj.deleteSport(sportName);
	}





}
