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
import com.ineuron.dto.IssuedBooks;
import com.ineuron.dto.Student;
import com.ineuron.service.StudentService;
import com.ineuron.student_factory.StudentServiceFactory;

//student servlet *
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static StudentService studentService = StudentServiceFactory.getStudentServiceBean();;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer sId = null;
		HttpSession session = request.getSession();
		
		
//
		if (session.getAttribute("librarian") == null)
			session.setAttribute("librarian", studentService.getAllLibranian());
		
		if (request.getPathInfo() == null) {
			
		    sId=(Integer) request.getAttribute("sId");

			session.setAttribute("sId", sId);
			
			System.out.println(session.getAttribute("sId"));
			
		    Student std = studentService.searchStudent(sId);
			session.setAttribute("sName", std.getsName());
			System.out.println(session.getAttribute("sName"));

			request.getRequestDispatcher("./stu/menu.jsp").forward(request, response);

		} else if (request.getPathInfo().equals("/issue")) {

			sId = (Integer) session.getAttribute("sId");
			Integer book_issued = studentService.noOfBookIssued(sId);
			Boolean error = false;

			// Book issued validation
			if (book_issued >= 3) {
				error = true;
				popupHandlerInvalid(request, response, "You have already issued 3 Books. You can't issue more");
			}

			// Book Validation
			Book book = studentService.getBookId(request.getParameter("author"), request.getParameter("title"),
					request.getParameter("category"));

			if (book == null) {
				error = true;
				popupHandlerInvalid(request, response, "This book is not present in our library");
			} else if (book.getPresentBooks().equals(0)) {
				error = true;
				popupHandlerInvalid(request, response, "Book Id " + book.getBid() + " is out of stock");
			}

			// checking if the student is issuing same book
			if (studentService.sameBookIssuingAgain(book.getBid(), sId)) {
				error = true;
				popupHandlerInvalid(request, response,
						"You already issued this book and you haven't return it. You can't issue same book again");
			}

			// issue book
			if (!error) {
				studentService.issueBook(sId, book.getBid(), Integer.parseInt(request.getParameter("lid")));
				popupHandlerSuccess(request, response, "Book issued successfully");
			}

		}
		/// /student/*
				if (request.getRequestURI().endsWith("submitfine")) {

					popupfine(request, response, "You have Succesfully given the fine Amount &#8377;"+session.getAttribute("fine"));

				}
				
				
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (request.getPathInfo().equals("/books")) {
			List<Book> books = studentService.getAllBooks();
			session.setAttribute("books", books);
			request.getRequestDispatcher("../stu/books.jsp").forward(request, response);

		} else if (request.getPathInfo().equals("/issuedBooks")) {

			List<IssuedBooks> issuedBooks = studentService.getIssuedBook((Integer) session.getAttribute("sId"));
			if (issuedBooks.isEmpty())
				popupHandlerInvalid(request, response, "You haven't issued any book till yet... ");
			else {

				session.setAttribute("issuedBooks", issuedBooks);
				request.getRequestDispatcher("../stu/return.jsp").forward(request, response);
			}
		} else if (request.getPathInfo().equals("/return")) {
			Book book = studentService.getBookId(request.getParameter("author"), request.getParameter("title"),
					request.getParameter("category"));
			Integer fine = studentService.getIssuedDate((Integer) session.getAttribute("sId"), book.getBid());
			request.setAttribute("fine", fine);
			session.setAttribute("fine", fine);
			request.getRequestDispatcher("../stu/fine.jsp").forward(request, response);
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
	public void popupfine(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);

		RequestDispatcher rd = request.getRequestDispatcher("../stu/popupfine.jsp");
		rd.forward(request, response);

	}
	

	public void handler(HttpServletRequest request, HttpServletResponse response, String output)
			throws ServletException, IOException {

		request.setAttribute("output", output);
		RequestDispatcher dispatcher = request.getRequestDispatcher("../stu/invalid.jsp");
		dispatcher.forward(request, response);

	}
}
