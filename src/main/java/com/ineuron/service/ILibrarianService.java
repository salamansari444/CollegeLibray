package com.ineuron.service;

import com.ineuron.dto.Librarian;

public interface ILibrarianService {

	boolean validateUser(String name, String password);

	String addLibrary(Librarian librarian);

}
