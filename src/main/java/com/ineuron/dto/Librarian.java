package com.ineuron.dto;

public class Librarian {

	private Integer lid;
	private String name;
	private String password;

	public Librarian(Integer lid, String name, String password) {
		
		this.lid = lid;
		this.name = name;
		this.password = password;
	}
	public Librarian() {
		System.out.println("Librarian Constructor");
	}
	public Integer getLid() {
		return lid;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Librarian [lid=" + lid + ", name=" + name + ", password=" + password + "]";
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
