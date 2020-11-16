package com.cybage.servlet;
import java.io.*; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;
import com.cybage.services.AdminServiceI;
import com.cybage.services.AdminServiceImpl;


public class AdminServlet extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(AdminServlet.class.getName()); 
	AdminServiceI adminServiceObj=new AdminServiceImpl();

	public AdminServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if(path.equals("/managerList")) {			
			try {
				List<Users> manager =  adminServiceObj.getManagers();
				logger.info("Getting all managers...");
				request.setAttribute("manager", manager);
				request.getRequestDispatcher("/Admin/managerList.jsp").forward(request, response);
			} catch (Exception e) {
				logger.info("something gone wrong while calling managers");
				e.printStackTrace();
			}
		}
		
		if(path.equals("/addManager")) {			
			try {
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				user.setAddress(request.getParameter("address"));
				user.setPhone(request.getParameter("phone"));
				user.setEmail(request.getParameter("email"));

				adminServiceObj.addManager(user);
				logger.info("adding Manager : " + user.getUsername());
				response.sendRedirect("managerList");								
			} catch (Exception e) {
				logger.info("Something went wrong while adding manager");
				e.printStackTrace();
			}
		}
		if(path.equals("/deleteManager")) {			
			try {
				adminServiceObj.deleteManager(request.getParameter("username"));
				request.setAttribute("deletemsg", "User deleted successfully");
				logger.info("manager deleted");
				response.sendRedirect("managerList");								
			} catch (Exception e) {
				request.getParameter("Something went wrong while deleting manager");
				e.printStackTrace();
			}
		}
		if(path.equals("/editManager")) {			
			try {
				logger.info("manager called for updation");
				Users manager = adminServiceObj.getManager(request.getParameter("username"));
				request.setAttribute("manager", manager);
				request.getRequestDispatcher("/Admin/updateManager.jsp").forward(request, response);								
			} catch (Exception e) {
				logger.info("Something went wrong while calling manager");
				e.printStackTrace();
			}
		}
		if(path.equals("/updateManager")) {			
			try {
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				user.setAddress(request.getParameter("address"));
				user.setPhone(request.getParameter("phone"));
				user.setEmail(request.getParameter("email"));

				adminServiceObj.updateManager(user);
				logger.info("manager updated");
				response.sendRedirect("managerList");										
			} catch (Exception e) {
				logger.info("Something went wrong while updating manager");
				e.printStackTrace();
			}
		}
		if(path.equals("/login")) {	
			logger.info("In Login page");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
		//**********************************Sports**********
		
		if(path.equals("/sportsList")) {			
			try {
				List<Sports> sports =  adminServiceObj.getSports();
				logger.info("Getting all sports...");
				request.setAttribute("sports", sports);
				request.getRequestDispatcher("/Admin/sportsList.jsp").forward(request, response);
			} catch (Exception e) {
				logger.info("something gone wrong while calling sports");
				e.printStackTrace();
			}
		}
		
		if(path.equals("/addSport")) {			
			try {
				Sports sports=new Sports();
				sports.setSportName(request.getParameter("sportName"));
				

				adminServiceObj.addSport(sports);
				logger.info("adding S : " + sports.getSportId());
				response.sendRedirect("sportsList");								
			} catch (Exception e) {
				logger.info("Something went wrong while adding sport");
				e.printStackTrace();
			}
		}
		if(path.equals("/deleteSport")) {			
			try {
				adminServiceObj.deleteSport(request.getParameter("sportName"));
				request.setAttribute("deletemsg", "Sport deleted successfully");
				logger.info("Sport deleted");
				response.sendRedirect("sportsList");								
			} catch (Exception e) {
				request.getParameter("Something went wrong while deleting sport");
				e.printStackTrace();
			}
		}
		//*****************************
		
		
		if(path.equals("/showLogs")) {
			try {
				Path reader =Paths.get("C:\\Users\\Administrator\\Desktop\\Deccan Sport Club\\DeccanSportClub1\\src\\main\\webapp\\log\\mylog.log");
		        
		        List<String> data =Files.readAllLines(reader);
//		      System.out.println(data);
		        data.parallelStream().forEach(System.out::println);
		    	request.setAttribute("fileData", data);
		    	request.getRequestDispatcher("/Admin/showLogs.jsp").forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//*************
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("post method called");
		doGet(request, response);
	}



}
