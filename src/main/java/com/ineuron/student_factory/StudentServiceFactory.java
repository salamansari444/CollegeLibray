package com.ineuron.student_factory;

import com.ineuron.service.StudentService;
import com.ineuron.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static StudentService studentService;

	private StudentServiceFactory() {

	}

	public static StudentService getStudentServiceBean() {

		if (studentService == null)
			studentService = new StudentServiceImpl();

		return studentService;
	}
}
