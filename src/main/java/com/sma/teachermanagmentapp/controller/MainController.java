//package com.sma.teachermanagmentapp.controller;
//
//import java.util.Scanner;
//
//import com.sma.teachermanagmentapp.dao.GroupDAO;
//import com.sma.teachermanagmentapp.dao.StudentDAO;
//import com.sma.teachermanagmentapp.dao.SubjectDAO;
//import com.sma.teachermanagmentapp.dao.TeacherDAO;
//import com.sma.teachermanagmentapp.dao.groupDAOImpl;
//import com.sma.teachermanagmentapp.dao.studentDAOImpl;
//import com.sma.teachermanagmentapp.dao.subjectDAOImpl;
//import com.sma.teachermanagmentapp.dao.teacherDAOImpl;
//import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
//import com.sma.teachermanagmentapp.properties.ApplicationProperties;
//import com.sma.teachermanagmentapp.service.GroupService;
//import com.sma.teachermanagmentapp.service.GroupServiceimpl;
//import com.sma.teachermanagmentapp.service.StudentService;
//import com.sma.teachermanagmentapp.service.StudentServiceimpl;
//import com.sma.teachermanagmentapp.service.SubjectService;
//import com.sma.teachermanagmentapp.service.SubjectServiceimpl;
//import com.sma.teachermanagmentapp.service.TeacherService;
//import com.sma.teachermanagmentapp.service.TeacherServiceimpl;
//
//public class MainController {
//
//	public static void main(String[] args) throws Exception {
//		TeacherDAO teacherDAO = new teacherDAOImpl();
//		TeacherService teacherService = new TeacherServiceimpl(teacherDAO);
//
//		StudentDAO studentDAO = new studentDAOImpl();
//		StudentService studentService = new StudentServiceimpl(studentDAO);
//
//		GroupDAO groupDAO = new groupDAOImpl();
//		GroupService groupService = new GroupServiceimpl(groupDAO);
//		
//		SubjectDAO subjectDAO = new subjectDAOImpl();
//		SubjectService subjectService = new SubjectServiceimpl(subjectDAO);
//		
//		Scanner sc = new Scanner(System.in);
//
//		ApplicationProperties.printMenu();
//		ApplicationProperties.printMenu2();
//		int selectedOperation = sc.nextInt();
//		try {
//			switch (selectedOperation) {
//			case 1:
//				System.out.println("MENU->Add teacher OPP");
//				teacherService.addTeachers();
//				main(args);
//				break;
//			case 2:
//				System.out.println("MENU->Get  teacher list");
//				teacherService.printTeachers();
//				main(args);
//				break;
//			case 3:
//				System.out.println("MENU->Get softDelete teacher By ID");
//				teacherService.printTeachers();
//				teacherService.softDeleteTeacher();
//				main(args);
//				break;
//			case 4:
//				System.out.println("MENU->Get hardDelete teacher By ID");
//				teacherService.printTeachers();
//				teacherService.hardDeleteTeacher();
//				main(args);
//				break;
//			case 5:
//				System.out.println("MENU->UpDate teacher Data By ID");
//				teacherService.printTeachers();
//			    teacherService.updateTeacherById();
//				main(args);
//				break;
//			case 6:
//				System.out.println("MENU->Add student");
//				studentService.addStudents();
//				main(args);
//				break;
//			
//			
//			case 7:
//				System.out.println("MENU->Get student list");
//				studentService.printStudents();
//				main(args);
//				break;
//			case 8:
//				System.out.println("MENU->Get softDelete student By ID");
//				studentService.printStudents();
//				studentService.softDeleteStudent();
//				main(args);
//				break;
//		
//			case 9:
//				System.out.println("MENU->Get hardDelete student By ID");
//				studentService.printStudents();
//				studentService.hardDeleteStudent();
//				main(args);
//				break;
//			case 10:
//				System.out.println("MENU->UpDate student Data By ID");
//				studentService.printStudents();
//			    studentService.updateStudentById();
//				main(args);
//				break;
//			case 11:
//				System.out.println("MENU->add group list");
//				groupService.addGroups();
//				main(args);
//				break;
//			case 12:
//				System.out.println("MENU->Get group list");
//				groupService.printGroups();
//				main(args);
//				break;
//			case 13:
//				System.out.println("MENU->Get softDelete group By ID");
//				groupService.printGroups();
//				groupService.softDeleteGroup();
//				main(args);
//				break;
//			case 14:
//				System.out.println("MENU->Get hardDelete group By ID");
//				groupService.printGroups();
//				groupService.hardDeleteGroup();
//				main(args);
//				break;
//			case 15:
//				System.out.println("MENU->UpDate group Data By ID");
//				groupService.printGroups();
//				groupService.updateGroupById();
//				main(args);
//				break;
//			case 16:
//				System.out.println("MENU->add subject list");
//				subjectService.addSubject();
//				main(args);
//				break;
//			case 17:
//				System.out.println("MENU->Get subject list");
//				subjectService.printSubjects();
//				main(args);
//				break;
//			case 18:
//				System.out.println("MENU->Get softDelete subject By ID");
//				subjectService.printSubjects();
//				subjectService.softDeleteSubject();
//				main(args);
//				break;
//			case 19:
//				System.out.println("MENU->Get hardDelete subject By ID");
//				subjectService.printSubjects();
//				subjectService.hardDeleteSubject();
//				main(args);
//				break;
//			case 20:
//				System.out.println("MENU->UpDAte subject Data By ID");
//				subjectService.printSubjects();
//				subjectService.updateSubjectById();
//				main(args);
//				break;
//			}
//		} catch (SeriaNumExceptions ex) {
//			System.err.println(ex.getMessage());
//			main(args);
//		} catch (Exception ex) {
//			System.err.println("bilinmeyen xeta");
//			main(args);
//		}
//
//	}
//}
