package com.ineuron.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ineuron.dto.Librarian;
import com.ineuron.utility.JdbcUtil;

public class LibrarianDaoImpl implements ILibrarianDao {

	Connection connection = JdbcUtil.getConnection();
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;

	@Override
	public boolean validateUser(String name, String password) {
		// TODO Auto-generated method stub
		String qry = "select lid from librarian where name=? and password=?";
		
			try {
				if(connection!=null) {
				pstmt=connection.prepareStatement(qry);
				}
				if(pstmt!=null) {
					pstmt.setString(1, name);
					pstmt.setString(2, password);
					resultSet=pstmt.executeQuery();
				}
				if(resultSet.next())
					return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			

		return false;
	}

	@Override
	public String addLibrary(Librarian librarian) {
		String qry= "insert into librarian(`name`,`password`) values(?,?)";
		Integer rowAffected=null;
		try {
			if(connection!=null) {
				pstmt = connection.prepareStatement(qry);
			}
			if(pstmt!=null) {
				pstmt.setString(1, librarian.getName());
				pstmt.setString(2, librarian.getPassword());
				
				rowAffected = pstmt.executeUpdate();
			}
			if(rowAffected==1) {
				
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

}
