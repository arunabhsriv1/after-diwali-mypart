package com.cybage.services;
import java.util.List;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;

public interface AdminServiceI {

	public List<Users> getManagers() throws Exception;
	public int addManager(Users user) throws Exception;
	public int deleteManager(String username) throws Exception;
	public Users getManager(String username) throws Exception;
	public int updateManager(Users user) throws Exception;
	
	
	public List<Sports> getSports() throws Exception;
	public int addSport(Sports sports) throws Exception;
	public int deleteSport(String sportName) throws Exception;

}
