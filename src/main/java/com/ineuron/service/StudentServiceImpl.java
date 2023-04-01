package com.ineuron.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import com.ineuron.dto.Book;
import com.ineuron.dto.IssuedBooks;
import com.ineuron.dto.Librarian;
import com.ineuron.dto.Student;
import com.ineuron.persistance.StudentDao;
import com.ineuron.student_factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Override
	public Integer validateStudent(String sName, Integer sClass, Integer sRollNo) {
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.validateStudent(sName, sClass, sRollNo);
	}

	@Override
	public Integer noOfBookIssued(Integer sId) {
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.noOfBookIssued(sId);
	}

	@Override
	public Book getBookId(String author, String title, String category) {
		return studentDao.getBookId(author, title, category);
	}

	@Override
	public List<Librarian> getAllLibranian() {
		return studentDao.getAllLibranian();
	}

	@Override
	public List<IssuedBooks> getIssuedBook(Integer sId) {
		return studentDao.getIssuedBook(sId);
	}

	@Override
	public boolean sameBookIssuingAgain(Integer bid, Integer sid) {
		return studentDao.sameBookIssuingAgain(bid, sid);
	}

	@Override
	public Boolean issueBook(Integer sid, Integer bid, Integer lid) {
		return studentDao.issueBook(sid, bid, lid);
	}

	@Override
	public List<Book> getAllBooks() {
		studentDao = StudentDaoFactory.getStudentDaoBean();

		return studentDao.getAllBooks();
	}

	@Override
	public Integer getIssuedDate(Integer sid, Integer bid) {

		java.sql.Date sd1 = studentDao.getIssuedDate(sid, bid);
		java.util.Date ud1 = new java.util.Date();
		long l = ud1.getTime();
		java.sql.Date sd2 = new java.sql.Date(l);
		Integer period = (int) (ChronoUnit.DAYS.between(sd1.toLocalDate(), sd2.toLocalDate()));

		if (period > 15) {
			studentDao.returnBook(sid, bid, period - 15, period);
			return (period - 15);
		} else {
			studentDao.returnBook(sid, bid, 0, period);
			return 0;
		}
	}

	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.addStudent(student);
	}

	@Override
	public String addBook(Book book) {
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.addBook(book);
	}

	@Override
	public Student searchStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.searchStudent(sid);
	}

	@Override
	public List<Student> getAllStudent() {
		studentDao = StudentDaoFactory.getStudentDaoBean();
		return studentDao.getAllStudent();
	}

	@Override
	public String deleteStudent(Integer sid) {
		studentDao=StudentDaoFactory.getStudentDaoBean();
		return studentDao.deleteStudent(sid);
	}

	@Override
	public String deleteBook(Integer bid) {
		studentDao=StudentDaoFactory.getStudentDaoBean();
		return studentDao.deleteBook(bid);
	}

	@Override
	public Integer countStudents() {
		// TODO Auto-generated method stub
		studentDao=StudentDaoFactory.getStudentDaoBean();

		return studentDao.countStudents() ;
	}

	@Override
	public Integer countBooks() {
		// TODO Auto-generated method stub
		studentDao=StudentDaoFactory.getStudentDaoBean();

		return studentDao.countBooks();
	}

}
