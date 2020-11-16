package com.cybage.dao;

import java.util.List;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public interface AdminDaoI {

	//functions for operations on manager 
	public List<Users> getAllManagers() throws Exception;
	public int addManager(Users user) throws Exception;
	public int deleteManager(String username) throws Exception;
	public Users getManager(String username) throws Exception;
	public int updateManager(Users user)  throws Exception;

	//funtions for operations on sports

	public List<Sports> getAllSports() throws Exception;
	public int addSport(Sports sport) throws Exception;
	public int deleteSport(String sportName) throws Exception;
	
}
