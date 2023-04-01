package com.ineuron.persistance;

import com.ineuron.dto.Librarian;

public interface ILibrarianDao {

	boolean validateUser(String name, String password);

	String addLibrary(Librarian librarian);

}
