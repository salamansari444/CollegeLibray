package com.ineuron.student_factory;

import com.ineuron.persistance.StudentDao;
import com.ineuron.persistance.StudentDaoImpl;

public class StudentDaoFactory {

	private static StudentDao studentDao;

	private StudentDaoFactory() {

	}

	public static StudentDao getStudentDaoBean() {

		if (studentDao == null)
			studentDao = new StudentDaoImpl();
		return studentDao;
	}
}
