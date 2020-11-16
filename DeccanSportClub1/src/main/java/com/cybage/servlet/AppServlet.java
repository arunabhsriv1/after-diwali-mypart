package com.cybage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin", "manager", "member"}
				)
		)
public class AppServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.isUserInRole("admin")) {
			request.getRequestDispatcher("/Admin/adminHome.jsp").forward(request, response);
		}
		if(request.isUserInRole("manager")) {
			request.getRequestDispatcher("/Manager/managerHome.jsp").forward(request, response);
		}
		if(request.isUserInRole("member")) {
			request.getRequestDispatcher("/Member/memberHome.jsp").forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
