package com.ineuron.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import com.ineuron.service.StudentService;
import com.ineuron.student_factory.StudentServiceFactory;
import com.ineuron.utility.JdbcUtil;

public class StudentFilter extends HttpFilter implements Filter {

	private StudentService studentService;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String sName = null;
		Integer sRollNo = null;
		Integer sclass = null;
		Integer sId = null;
		Boolean error = false;
		try {

			sName = request.getParameter("sName");
			sRollNo = Integer.parseInt(request.getParameter("sRollNo"));
			sclass = Integer.parseInt(request.getParameter("sClass"));
			studentService = StudentServiceFactory.getStudentServiceBean();
			sId = studentService.validateStudent(sName, sclass, sRollNo);

		} catch (NumberFormatException e) {
			error = true;
			handler(request, response, "Please enter only numeric value or the data can't be empty");
		}

		if (sId != null && !error) {
			request.setAttribute("sId", sId);
			chain.doFilter(request, response);
		} else {
			error = false;
			handler(request, response, "Please enter valid credentials");

		}
	}

	public void handler(ServletRequest request, ServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./stu/credential.jsp");
		dispatcher.forward(request, response);

	}

	
	
}
