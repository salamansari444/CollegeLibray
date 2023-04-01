package com.ineuron.factory;

import com.ineuron.persistance.ILibrarianDao;
import com.ineuron.persistance.LibrarianDaoImpl;
import com.ineuron.service.ILibrarianService;
import com.ineuron.service.LibrarianServiceImpl;

public class LibrarianServiceFactory {
	private static ILibrarianService libraryService=null;

	private LibrarianServiceFactory() {

	}

	public static ILibrarianService getLibraryServiceBean() {

		if (libraryService == null)
			libraryService = new LibrarianServiceImpl();
		return libraryService;
	}
}
