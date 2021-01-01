package com.sma.teachermanagmentapp.service;

import com.sma.teachermanagmentapp.model.Student;

public interface StudentService {
	public boolean addStudents();

	public void printStudents();

	public void softDeleteStudent();

	public void hardDeleteStudent();

	public Student getStudentById();

	public void updateStudentById();

	public void printStudent(Student student);
}
