package com.sma.teachermanagmentapp.db;

import java.util.HashMap;
import java.util.Map;

import com.sma.teachermanagmentapp.model.Group;
import com.sma.teachermanagmentapp.model.Student;
import com.sma.teachermanagmentapp.model.Subject;
import com.sma.teachermanagmentapp.model.Teacher;

public class DbClass {
	public static Map<String, Teacher> teacherList = new HashMap<String, Teacher>();
	public static Map<String, Student> studentList = new HashMap<String, Student>();
	public static Map<String, Group> groupList = new HashMap<String, Group>();
	public static Map<String, Subject> subjectList = new HashMap<String, Subject>();
}
