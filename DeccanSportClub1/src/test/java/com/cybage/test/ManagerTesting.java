package com.cybage.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.cybage.pojos.Plans;
import com.cybage.services.ManagerServiceI;
import com.cybage.services.ManagerServiceImpl;

class ManagerTesting {

	ManagerServiceI managerServiceObj=new ManagerServiceImpl();
	
	Plans plan=new Plans(101, "plan testing", 12300, 7);	
	
	@Test
	void testAddPlan() throws Exception {
		managerServiceObj.addPlan(plan);
		assertNotNull(managerServiceObj.getPlanByName("plan testing"));
	}


	@Test
	void testUpdatePlan() throws Exception {
		plan.setPlanName("plan updated");
		plan.setFees(6578);
		plan.setDuration(6);
		assertEquals(1, managerServiceObj.updatePlan(plan));
	}

	@Test
	void testGetAllPlans() throws Exception {
		assertNotNull(managerServiceObj.getAllPlans());
	}

	@Test
	void testGetPlan() throws Exception {
		assertNotNull(managerServiceObj.getPlan(plan.getPlanId()));		
	}
	
	@Test
	void testRemovePlan() throws Exception {
		assertNull(managerServiceObj.removePlan(plan.getPlanId()));
	}

}
