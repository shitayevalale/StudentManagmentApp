package com.sma.teachermanagmentapp.service;

import com.sma.teachermanagmentapp.model.Teacher;

public interface TeacherService {
	public boolean addTeachers();

	public void printTeachers();

	public void softDeleteTeacher();

	public void hardDeleteTeacher();

	public Teacher getTeacherById();

	public void updateTeacherById();

	public void printTeacher(Teacher teacher);
}
