package com.ineuron.service;

import com.ineuron.dto.Librarian;
import com.ineuron.factory.LibraryDaoFactory;
import com.ineuron.persistance.ILibrarianDao;
import com.ineuron.persistance.LibrarianDaoImpl;

public class LibrarianServiceImpl implements ILibrarianService {

	ILibrarianDao libraryDao = LibraryDaoFactory.getLibraryDaoBean();

	@Override
	public boolean validateUser(String name, String password) {

		return libraryDao.validateUser(name, password);

	}

	@Override
	public String addLibrary(Librarian librarian) {
		
		return libraryDao.addLibrary(librarian);
	}

}
