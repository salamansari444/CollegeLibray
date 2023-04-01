package com.ineuron.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ineuron.dto.Book;
import com.ineuron.dto.IssuedBooks;
import com.ineuron.dto.Librarian;
import com.ineuron.dto.Student;
import com.ineuron.utility.JdbcUtil;

public class StudentDaoImpl implements StudentDao {

	private static Connection connection = JdbcUtil.getConnection();
	private ResultSet rs;

	@Override
	public Integer validateStudent(String sName, Integer sClass, Integer sRollNo) {

		try {

			PreparedStatement pstmt = connection
					.prepareStatement("SELECT sid FROM students WHERE name=? AND class=? AND roll_no=? ;");
			pstmt.setString(1, sName);
			pstmt.setInt(2, sClass);
			pstmt.setInt(3, sRollNo);
			rs = pstmt.executeQuery();

			if (rs.next())
				return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer noOfBookIssued(Integer sId) {

		Integer book_issued = null;

		try {

			PreparedStatement pstmt = connection.prepareStatement("SELECT book_issued FROM students WHERE sid=?;");
			pstmt.setInt(1, sId);
			rs = pstmt.executeQuery();
			rs.next();
			book_issued = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book_issued;

	}

	@Override
	public List<Librarian> getAllLibranian() {
		List<Librarian> librarians = new ArrayList<>();
		try {

			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM librarian;");
			rs = pstmt.executeQuery();

			while (rs.next())
				librarians.add(new Librarian(rs.getInt(1), rs.getString(2), rs.getString(3)));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return librarians;

	}

	@Override
	public List<IssuedBooks> getIssuedBook(Integer sId) {

		List<IssuedBooks> issuedBooks = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT b.author, b.title, b.category, i.issue_date FROM issue AS i INNER JOIN books AS b ON i.bid=b.bid AND i.sid=? AND i.is_done=false;"
							+ "");
			pstmt.setInt(1, sId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				issuedBooks.add(new IssuedBooks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
				System.out
						.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getDate(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issuedBooks;
	}

	@Override
	public boolean sameBookIssuingAgain(Integer bid, Integer sid) {

		try {

			PreparedStatement pstmt = connection
					.prepareStatement("SELECT iid FROM issue WHERE sid=? AND bid=? AND is_done=false;");
			pstmt.setInt(1, sid);
			pstmt.setInt(2, bid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean issueBook(Integer sid, Integer bid, Integer lid) {

		try {

			// insert data in issue table
			PreparedStatement pstmt1 = connection.prepareStatement(
					"INSERT INTO issue(sid, bid, lid, is_done, issue_date) VALUES(?, ?, ?, ?, curdate());");
			pstmt1.setInt(1, sid);
			pstmt1.setInt(2, bid);
			pstmt1.setInt(3, lid);
			pstmt1.setBoolean(4, false);
			pstmt1.executeUpdate();

			PreparedStatement pstmt2 = connection
					.prepareStatement("UPDATE students SET book_issued= book_issued + 1 WHERE sid=?");
			pstmt2.setInt(1, sid);
			pstmt2.executeUpdate();

			PreparedStatement pstmt3 = connection
					.prepareStatement("UPDATE books SET present_books= present_books - 1 WHERE bid=?");
			pstmt3.setInt(1, bid);
			pstmt3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public List<Book> getAllBooks() {

		List<Book> books = new ArrayList<>();
		try {

			PreparedStatement pstmt = connection.prepareStatement("SELECT bid,author,title,category,total_books,present_books FROM books;");
			rs = pstmt.executeQuery();

			while (rs.next())
				books.add(new Book(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Date getIssuedDate(Integer sid, Integer bid) {

		Date d = null;
		try {

			PreparedStatement pstmt = connection
					.prepareStatement("SELECT issue_date FROM issue WHERE sid=? AND bid=? AND is_done=false;");
			pstmt.setInt(1, sid);
			pstmt.setInt(2, bid);
			rs = pstmt.executeQuery();

			if (rs.next())
				d = rs.getDate(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	public void returnBook(Integer sid, Integer bid, Integer fine, Integer period) {
		try {

			// insert data in issue table
			PreparedStatement pstmt1 = connection.prepareStatement(
					"UPDATE  issue  SET  is_done= ?, period =?, fine=?, return_date=curdate() WHERE sid=? AND bid=? AND is_done=false;");
			pstmt1.setInt(4, sid);
			pstmt1.setInt(5, bid);
			pstmt1.setBoolean(1, true);
			pstmt1.setInt(2, period);
			pstmt1.setInt(3, fine);
			pstmt1.executeUpdate();

			PreparedStatement pstmt2 = connection
					.prepareStatement("UPDATE students SET book_issued= book_issued - 1 WHERE sid=?");
			pstmt2.setInt(1, sid);
			pstmt2.executeUpdate();

			PreparedStatement pstmt3 = connection
					.prepareStatement("UPDATE books SET present_books= present_books + 1 WHERE bid=?");
			pstmt3.setInt(1, bid);
			pstmt3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sqlInsertQuery = "insert into students(`name`,`class`,`roll_no`)values(?,?,?)";
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery, Statement.RETURN_GENERATED_KEYS);
			}
			if (pstmt != null) {

				pstmt.setString(1, student.getsName());
				pstmt.setInt(2, student.getsClass());
				pstmt.setInt(3, student.getsRollNo());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					ResultSet rs = pstmt.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						student.setsId(id);
						System.out.println("Currnet id :: " + id);
					}
					return "success";
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Book getBookId(String author, String title, String category) {

		try {

			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT bid,total_books,present_books FROM books WHERE author=? AND title=? AND category=?;");
			pstmt.setString(1, author);
			pstmt.setString(2, title);
			pstmt.setString(3, category);
			rs = pstmt.executeQuery();

			if (rs.next())
				return new Book(rs.getInt(1), author, title, category, rs.getInt(2), rs.getInt(3));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addBook(Book book) {
		String updateQry = "update books set `total_books`=?,`present_books`=? where `bid`=?";
		String insertQry = "insert into books (`author`,`title`,`category`,`total_books`,`present_books`) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			connection = JdbcUtil.getConnection();
			Book presentBook = getBookId(book.getAuthor(), book.getTitle(), book.getCategory());
			// Book Already Presnt
			if (presentBook != null) {
				int total = presentBook.getTotalBooks() + book.getTotalBooks();
				presentBook.setTotalBooks(total);
				int present = presentBook.getPresentBooks() + book.getTotalBooks();
				presentBook.setPresentBooks(present);
				if (connection != null) {
					pstmt = connection.prepareStatement(updateQry);
					if (pstmt != null) {
						pstmt.setInt(1, total);
						pstmt.setInt(2, present);
						pstmt.setInt(3, presentBook.getBid());
						Integer rowAffected = pstmt.executeUpdate();
						if (rowAffected != null) {
							System.out.println("Updated the books");
							return "success";
						}
					}

				} else {
					System.out.println("Connection is null");
				}

			} else {
				// AddBook
				if (connection != null)
					pstmt = connection.prepareStatement(insertQry);
				if (pstmt != null) {
					pstmt.setString(1, book.getAuthor());
					pstmt.setString(2, book.getTitle());
					pstmt.setString(3, book.getCategory());
					pstmt.setInt(4, book.getTotalBooks());
					pstmt.setInt(5, book.getTotalBooks());

				}

			}

			Integer rowAffected = null;
			if (pstmt != null) {
				rowAffected = pstmt.executeUpdate();
			}

			if (rowAffected != null) {
				System.out.println("Successfully added book" + book);
				return "success";

			} else {
				System.out.println("Failed to Add book");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "failed";
	}

	// Search Student
	@Override
	public Student searchStudent(Integer sid) {
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlSelectQuery = "select sid, name,class,book_issued,roll_no from students where sid=?";
		Student std = null;
		try {
			connection = JdbcUtil.getConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, sid);
				if (pstmt != null) {
					resultSet = pstmt.executeQuery();
				}

				if (resultSet.next()) {
					std = new Student();
					std.setsId(resultSet.getInt(1));
					std.setsName(resultSet.getString(2));
					std.setsClass(resultSet.getInt(3));
					std.setBookIssued(resultSet.getInt(4));
					std.setsRollNo(resultSet.getInt(5));

					return std;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent()  {
	List<Student> students=new ArrayList<>();
	PreparedStatement pstmt=null;
	String qry="Select * from students";
	try {
		if(connection != null ) {
			pstmt=connection.prepareStatement(qry);
		}
		if(pstmt!=null) {
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Student std=new Student();
				std.setsId(rs.getInt(1));
				std.setsName(rs.getString(2));
				std.setsClass(rs.getInt(3));
				std.setBookIssued(rs.getInt(4));
				std.setsRollNo(rs.getInt(5));
				
				students.add(std);
			}
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return students;
	}

	@Override
	public String deleteStudent(Integer sid) {
		String deleteQry="delete from students where sid=?";
		PreparedStatement pstmt=null;
		Integer rowAffected=null;
		String msg="";
		
		try {
			pstmt=connection.prepareStatement(deleteQry);
			if(pstmt!=null) {
				pstmt.setInt(1, sid);
				rowAffected = pstmt.executeUpdate();
			}
			if(rowAffected!=null) {
					return "success";
					
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return msg="failed";
	}

	@Override
	public String deleteBook(Integer bid) {
		String deleteQry="delete from books where bid=?";
		PreparedStatement pstmt=null;
		Integer rowAffected=null;
		String msg="";
		
		try {
			pstmt=connection.prepareStatement(deleteQry);
			if(pstmt!=null) {
				pstmt.setInt(1, bid);
				rowAffected = pstmt.executeUpdate();
			}
			if(rowAffected!=null) {
					return "success";
					
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return msg="failed";
	}

	@Override
	public Integer countStudents() {
		// TODO Auto-generated method stub
		
		String sql="select count(*) from students";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
			 try {
			if(connection!=null) 
				pstmt = connection.prepareStatement(sql);
			if(pstmt!=null) {
				 rs = pstmt.executeQuery();
			}
			if(rs.next())
				return rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public Integer countBooks() {
		// TODO Auto-generated method stub
		return null;
	}
}
