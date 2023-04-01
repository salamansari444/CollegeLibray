package com.ineuron.factory;

import com.ineuron.persistance.ILibrarianDao;
import com.ineuron.persistance.LibrarianDaoImpl;

public class LibraryDaoFactory {
	
	private static ILibrarianDao libraryDao=null;

	private LibraryDaoFactory() {

	}

	public static ILibrarianDao getLibraryDaoBean() {

		if (libraryDao == null)
			libraryDao = new LibrarianDaoImpl();
		return libraryDao;
	}
}
