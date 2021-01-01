package com.sma.teachermanagmentapp.controller;

import java.util.Scanner;

import com.sma.teachermanagmentapp.dao.StudentDAO;
import com.sma.teachermanagmentapp.dao.studentDAOImpl;
import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;
import com.sma.teachermanagmentapp.service.StudentService;
import com.sma.teachermanagmentapp.service.StudentServiceimpl;

public class StudentController {
	public static void studentController() throws Exception {
		Scanner sc = new Scanner(System.in);
		StudentDAO studentDAO = new studentDAOImpl();
		StudentService studentService = new StudentServiceimpl(studentDAO);
		ApplicationProperties.printMenu2();
		int selectedOperation = sc.nextInt();
		try {
			switch (selectedOperation) {

			case 1:
				System.out.println("MENU->Add student");
				studentService.addStudents();

				break;

			case 2:
				System.out.println("MENU->Get student list");
				studentService.printStudents();
				break;
			case 3:
				System.out.println("MENU->Get softDelete student By ID");
				studentService.printStudents();
				studentService.softDeleteStudent();

				break;

			case 4:
				System.out.println("MENU->Get hardDelete student By ID");
				studentService.printStudents();
				studentService.hardDeleteStudent();

				break;
			case 5:
				System.out.println("MENU->UpDate student Data By ID");
				studentService.printStudents();
				studentService.updateStudentById();

				break;

			}
		} catch (SeriaNumExceptions ex) {
			System.err.println(ex.getMessage());

		} catch (Exception ex) {
			System.err.println("bilinmeyen xeta");

		}

	}
}
