package com.ineuron.service;

import java.util.List;

import com.ineuron.dto.Book;
import com.ineuron.dto.IssuedBooks;
import com.ineuron.dto.Librarian;
import com.ineuron.dto.Student;

public interface StudentService {
	Integer validateStudent(String sName, Integer sClass, Integer sRollNo);

	Integer noOfBookIssued(Integer sId);

	Book getBookId(String author, String title, String category);

	List<Librarian> getAllLibranian();

	List<IssuedBooks> getIssuedBook(Integer sId);

	boolean sameBookIssuingAgain(Integer bid, Integer sid);

	Boolean issueBook(Integer sid, Integer bid, Integer lid);

	List<Book> getAllBooks();

	Integer getIssuedDate(Integer sid, Integer bid);

	String addStudent(Student student);

	String addBook(Book book);

	Student searchStudent(Integer sid);

	List<Student> getAllStudent();
	
	String deleteStudent(Integer sid);
	String deleteBook(Integer bid);
	
Integer countStudents();
	
	Integer countBooks();
}
