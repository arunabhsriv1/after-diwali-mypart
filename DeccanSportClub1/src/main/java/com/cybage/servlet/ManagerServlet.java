package com.cybage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.pojos.AllBatchInfo;
import com.cybage.pojos.Batch;
import com.cybage.pojos.Enrollment;
import com.cybage.pojos.Plans;
import com.cybage.pojos.Users;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"manager"}
				)
		)
public class ManagerServlet extends HttpServlet {
	public static final Logger logger = LogManager.getLogger(ManagerServlet.class.getName()); 

	
	ManagerServiceI manager=new ManagerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		
		if(path.equals("/listbatch")) {			
			try {
				List<AllBatchInfo> listbatch=manager.getAllBatches();
				
				request.setAttribute("batches", listbatch);
				request.getRequestDispatcher("/Manager/manager-batches.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/addbatch")) {			
			try {
				Batch batchinfo= new Batch();
				
				batchinfo.setStartDate(manager.getDate(request.getParameter("startDate")));
				batchinfo.setEndDate(manager.getDate(request.getParameter("endDate")));
			
				batchinfo.setBatchSize(Integer.parseInt(request.getParameter("batchSize")));
				batchinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				batchinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				
				manager.addBatch(batchinfo);
				response.sendRedirect("listbatch");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/deletebatch")) {			
			try {
				manager.removeBatch(Integer.parseInt(request.getParameter("batchId")));
				
			
				response.sendRedirect("listbatch");								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if(path.equals("/editbatch")) {			
			try {
				Batch batch=manager.getBatch(Integer.parseInt(request.getParameter("batchId")));
				
				request.setAttribute("batches", batch);
				request.getRequestDispatcher("/Manager/update-batch.jsp").forward(request, response);								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/updatebatch")) {			
			try {
				
				Batch batchinfo =new Batch();
				batchinfo.setBatchId(Integer.parseInt(request.getParameter("batchId")));
				batchinfo.setStartDate(manager.getDate(request.getParameter("startDate")));
				batchinfo.setEndDate(manager.getDate(request.getParameter("endDate")));
			
				batchinfo.setBatchSize(Integer.parseInt(request.getParameter("batchSize")));
				batchinfo.setSportId(Integer.parseInt(request.getParameter("sportId")));
				batchinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				manager.updateBatch(batchinfo);
				
				
				response.sendRedirect("listbatch");										
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/managerprofile")) {			
			try {
				HttpSession session =request.getSession(true);
				String username=(String)session.getAttribute("username");
				Users user=manager.getManager(username);
				System.out.println(user.toString());
				request.setAttribute("managerprofile", user);
				request.getRequestDispatcher("/Manager/manager-profile.jsp").forward(request, response);
												
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/listenrolledmembers")) {			
			try {
				List<AllBatchInfo> enrolledbatch = manager.getAllEnrolledMembers();
				System.out.println( enrolledbatch.toString());
				request.setAttribute("enrolledbatches", enrolledbatch);
				request.getRequestDispatcher("/Manager/enrolled-members.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/approvemember")) {			
			try {
				Enrollment enrlmnt=new Enrollment();
				if(Integer.parseInt(request.getParameter("batchSize"))==0)
				{
					throw new Exception("No seat available");
				}
				
				
				manager.updateBatchSize(Integer.parseInt(request.getParameter("enrollId")),Integer.parseInt(request.getParameter("batchSize")));
				enrlmnt.setEnrollId(Integer.parseInt(request.getParameter("enrollId")));
				manager.approveEnrollment(enrlmnt);
				
				response.sendRedirect("listenrolledmembers");										
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(path.equals("/rejectmember")) {			
			try {
				Enrollment enrlmnt=new Enrollment();
				enrlmnt.setEnrollId(Integer.parseInt(request.getParameter("enrollId")));
				manager.rejectEnrollment(enrlmnt);
				
				response.sendRedirect("listenrolledmembers");										
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		///////Servlet Methods for Plan
		
		if(path.equals("/listplan")) {			
			try {
				List<Plans> listplan=manager.getAllPlans();
				logger.info("List All Plans...");
				request.setAttribute("plans", listplan);
				request.getRequestDispatcher("/Manager/manager-plans.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/addplan")) {			
			try {
				Plans planinfo=new Plans();
				logger.info("New Plan Added...");
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));
				
				manager.addPlan(planinfo);
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/deleteplan")) {			
			try {
				manager.removePlan(Integer.parseInt(request.getParameter("planId")));
				logger.info("Desired plan removed");
				request.setAttribute("deletemsg", "Plan deleted successfully");
				response.sendRedirect("listplan");								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if(path.equals("/editplan")) {			
			try {
				Plans plan=manager.getPlan(Integer.parseInt(request.getParameter("planId")));
				logger.info("Selected the plan to be updated...");
				request.setAttribute("plans", plan);
				request.getRequestDispatcher("/Manager/update-plan.jsp").forward(request, response);								
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/updateplan")) {			
			try {
				
				Plans planinfo=new Plans();
				logger.info("Plan Updated, desired changes made...");
				planinfo.setPlanId(Integer.parseInt(request.getParameter("planId")));
				planinfo.setPlanName(request.getParameter("planName"));
				planinfo.setFees(Double.parseDouble(request.getParameter("fees")));
				planinfo.setDuration(Integer.parseInt(request.getParameter("duration")));
				
				manager.updatePlan(planinfo);
				
				
				response.sendRedirect("listplan");										
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
 	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

				
		
		
		
		
}
	

	

