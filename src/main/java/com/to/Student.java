package com.to;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue
	private int student_id;
	private String student_name;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Classes classes;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	

}
