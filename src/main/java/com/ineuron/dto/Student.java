package com.ineuron.dto;

public class Student {

	private Integer sId;
	private String sName;
	private Integer sClass;
	private Integer sRollNo;
	private Integer bookIssued;

	public Student(Integer sId, String sName, Integer sClass, Integer sRollNo,Integer bookIssued) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sClass = sClass;
		this.sRollNo = sRollNo;
		this.bookIssued=bookIssued;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sClass=" + sClass + ", sRollNo=" + sRollNo
				+ ", bookIssued=" + bookIssued + "]";
	}

	public Integer getsId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setsClass(Integer sClass) {
		this.sClass = sClass;
	}

	public void setsRollNo(Integer sRollNo) {
		this.sRollNo = sRollNo;
	}

	public Integer getsClass() {
		return sClass;
	}

	public Integer getsRollNo() {
		return sRollNo;
	}

	public Integer getBookIssued() {
		return bookIssued;
	}

	public void setBookIssued(Integer bookIssued) {
		this.bookIssued = bookIssued;
	}
	

}
