package com.ineuron.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ineuron.dto.Book;
import com.ineuron.dto.Librarian;
import com.ineuron.dto.Student;
import com.ineuron.factory.LibrarianServiceFactory;
import com.ineuron.service.ILibrarianService;
import com.ineuron.service.StudentService;
import com.ineuron.student_factory.StudentServiceFactory;

/**
 * Servlet implementation class MainController
 */

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	StudentService stdService = StudentServiceFactory.getStudentServiceBean();

	ILibrarianService libService = LibrarianServiceFactory.getLibraryServiceBean();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer totalStudent = stdService.countStudents();
		request.setAttribute("totalStudent", totalStudent);
		System.out.println(totalStudent);
		
		
		//ValidateLibrary Authentication
		if (request.getRequestURI().endsWith("validatelibrarian")) {
			try {
			System.out.println("validateLibrarian");
			String name = request.getParameter("name");

			String password = request.getParameter("password");

			boolean msg = libService.validateUser(name, password);

			if (msg) {
				System.out.println("ha ye libraian");
				response.sendRedirect("../stu/Library.jsp");
//				RequestDispatcher rd = request.getRequestDispatcher("../stu/Library.jsp");
//				rd.include(request, response);

			} else {
				System.out.println("Invalid");

				popupHandlerInvalid(request, response, "Invalid Credential Chor saale.......");

			}
			}catch(Exception e) {
				popupHandlerInvalid(request, response, "Invalid Credential Chor saale.......");
			}
			

		}
		
		//signUp Librarian
		if (request.getRequestURI().endsWith("addlibrarian")) {
			try {
			System.out.println("add Library");
			Librarian librarian=new Librarian();
			
			String name = request.getParameter("signin-username");
			String password = request.getParameter("signin-password");
			
			librarian.setName(name);
			librarian.setPassword(password);
			
			String msg=libService.addLibrary(librarian);
			if (msg.equalsIgnoreCase("success")) {
				System.out.println("Succesffullly added");
				System.out.println(librarian.getLid());
				String output = "Succesffullly added the Librarian with id :: " + librarian.getLid()+" you can login Now";
				
				popupHandlerSuccess(request, response, output);
			} else {
				System.out.println("Wasted");
				popupHandlerInvalid(request, response, "Invalid Details Chor saale.......");
			}
			}catch(Exception e) {
				popupHandlerInvalid(request, response, "Invalid Details Chor saale.......");
			}
			
		}
		
		
		
		//Add Student
		if (request.getRequestURI().endsWith("addStudent")) {
			try {
			System.out.println("hi student added");
			Student student = new Student();

			Integer classNo = Integer.parseInt(request.getParameter("class"));
			String name = request.getParameter("name");
			Integer rollno = Integer.parseInt(request.getParameter("rollNo"));

			student.setsClass(classNo);
			student.setsName(name);
			student.setsRollNo(rollno);
			System.out.println(student);
			String msg = stdService.addStudent(student);
			if (msg.equalsIgnoreCase("success")) {
				System.out.println("Succesffullly added");
				System.out.println(student.getsId());
				String output = "Succesffullly added the student with id :: " + student.getsId();
				popupHandlerSuccess(request, response, output);
			} else {
				System.out.println("Wasted");
				popupHandlerInvalid(request, response, "Failed to Add Student Try Again.......");
			}
			}
			catch(Exception e) {
				popupHandlerInvalid(request, response, "Failed to Add Student Try Again.......");
			}

		}
		
		//Add Book
		if (request.getRequestURI().endsWith("addBook")) {
			System.out.println("addbook");
			try {
			Book book = new Book();
			String author = request.getParameter("author");
			String title = request.getParameter("title");
			String category = request.getParameter("category");
			String quantity = request.getParameter("quantity");

			book.setAuthor(author);
			book.setTitle(title);
			book.setCategory(category);
			book.setTotalBooks(Integer.parseInt(quantity));

			System.out.println(book);
			String msg = stdService.addBook(book);
			if (msg.equalsIgnoreCase("success")) {
				System.out.println("Succesffullly added");

				String output = "Succesffullly added the Book";
				popupHandlerSuccess(request, response, output);
			} else {
				System.out.println("Wasted");
				popupHandlerInvalid(request, response, "Invalid Data Enter");
			}
			}
			catch(Exception e) {
				popupHandlerInvalid(request, response, "Invalid Data Enter");

			}
		}

		// search student
		if (request.getRequestURI().endsWith("searchStudent")) {
			
			String sid = request.getParameter("sid");
			try {
			System.out.println("searchStudent");

			System.out.println(sid);

			Student student = stdService.searchStudent(Integer.parseInt(sid));
			if (student != null) {
				System.out.println("Succesffullly searched");
				request.setAttribute("student", student);

				RequestDispatcher rd = request.getRequestDispatcher("../stu/students.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("Wasted");
				popupHandlerInvalid(request, response, "Data for id : "+"<b>"+ sid +"</b> not available");
			}
			}catch(Exception e) {
				popupHandlerInvalid(request, response, "Data for id : "+"<b>"+ sid +"</b> not available");
			}

		}
		
		//All Students List
		if (request.getRequestURI().endsWith("allStudents")) {
			System.out.println("allStud");
			List<Student> allStudent = stdService.getAllStudent();
			for (Student stu : allStudent)
				System.out.println(stu);

//			request.setAttribute("allStudent", allStudent);
//			RequestDispatcher rd = request.getRequestDispatcher("../stu/allStudents.jsp");
//			rd.forward(request, response);

		}

	}



	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer totalStudent = stdService.countStudents();
		System.out.println(totalStudent);
		
		if (request.getRequestURI().endsWith("allStudents")) {
			System.out.println("allStud");
			List<Student> allStudent = stdService.getAllStudent();

			request.setAttribute("allStudent", allStudent);
			RequestDispatcher rd = request.getRequestDispatcher("../stu/allStudents.jsp");
			rd.forward(request, response);

		}
		//DELETE STUDENT
		if (request.getRequestURI().endsWith("deleteStudentServlet")) {
			try {
			System.out.println("deleteStudent");
			Student student = null;

			Integer sid = Integer.parseInt(request.getParameter("sid"));
			String std = request.getParameter("sname");
			
			String deleteStudent = stdService.deleteStudent(sid);
			System.out.println(deleteStudent);
			String output = null;
			if (deleteStudent.equalsIgnoreCase("failed")) {
				output = "sorry this student issued some books can't delete ............";
				popupHandlerInvalid(request, response, output);


			} else {

				output = "Student with " + "<b>"+ std +"</b>" + " is deleted";
				popupHandlerSuccess(request, response, output);

			}
			}catch(Exception e) {
				 e.printStackTrace();
				
			}
		}

		if (request.getRequestURI().endsWith("allBooks")) {
			System.out.println("allBook");
			List<Book> allBook = stdService.getAllBooks();

			request.setAttribute("allBook", allBook);
			RequestDispatcher rd = request.getRequestDispatcher("../stu/books.jsp");
			rd.forward(request, response);

		}
		
		//DELETE BOOK
		if (request.getRequestURI().endsWith("deleteBookServlet")) {
			
			
			System.out.println("deleteBook");
			Book book = null;

			Integer bid = Integer.parseInt(request.getParameter("bid"));
			String bname = request.getParameter("bname");
			String deleteBook = stdService.deleteBook(bid);
			System.out.println(deleteBook);
			String output = null;
			try {
			if (deleteBook.equalsIgnoreCase("failed")) {
				output = "sorry this Book issued by some Student can't delete ............";
				popupHandlerInvalid(request, response, output);

			} else {
				
				output = "Book  " + "<b>"+ bname +"</b>" + "  data is deleted";

				popupHandlerSuccess(request, response, output);
			}
			}
			catch(Exception e) {
				output = "Book " + "<b>"+ bname +"</b>" + "  data is deleted";

				popupHandlerSuccess(request, response, output);
			}
		}
		
		
		//LogOut
		if(request.getRequestURI().endsWith("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("../welcome.jsp");
		}
		
		
	}

	public void popupHandlerSuccess(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);

		RequestDispatcher rd = request.getRequestDispatcher("../stu/popup.jsp");
		rd.forward(request, response);

	}
	
	public void popupHandlerInvalid(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);

		RequestDispatcher rd = request.getRequestDispatcher("../stu/popupInvalid.jsp");
		rd.forward(request, response);

	}
	
	
	public void handler(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../stu/invalid.jsp");
		dispatcher.forward(request, response);

	}
}
