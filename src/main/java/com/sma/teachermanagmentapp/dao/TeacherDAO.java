package com.sma.teachermanagmentapp.dao;

import java.util.List;

import com.sma.teachermanagmentapp.model.Student;
import com.sma.teachermanagmentapp.model.Teacher;

public interface TeacherDAO {
	public boolean saveTeacher(Teacher teacher);

	public List<Teacher> getTeachers();

	public boolean softDeleteTeacher(Long id);

	public boolean hardDeleteTeacher(Long id);

	public Teacher getTeacherById(Long id);

	public boolean updateTeacherById(Teacher teacher);
}
