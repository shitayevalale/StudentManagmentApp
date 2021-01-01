package com.sma.teachermanagmentapp.controller;

import java.util.Scanner;

import com.sma.teachermanagmentapp.dao.TeacherDAO;
import com.sma.teachermanagmentapp.dao.teacherDAOImpl;
import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;
import com.sma.teachermanagmentapp.service.TeacherService;
import com.sma.teachermanagmentapp.service.TeacherServiceimpl;

public class TeacherController {
	public static void teacherController() throws Exception {
		Scanner sc = new Scanner(System.in);
		TeacherDAO teacherDAO = new teacherDAOImpl();
		TeacherService teacherService = new TeacherServiceimpl(teacherDAO);
		ApplicationProperties.printMenu1();
		int selectedOperation = sc.nextInt();
		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("MENU->Add teacher OPP");
				teacherService.addTeachers();

				break;
			case 2:
				System.out.println("MENU->Get  teacher list");
				teacherService.printTeachers();

				break;
			case 3:
				System.out.println("MENU->Get softDelete teacher By ID");
				teacherService.printTeachers();
				teacherService.softDeleteTeacher();

				break;
			case 4:
				System.out.println("MENU->Get hardDelete teacher By ID");
				teacherService.printTeachers();
				teacherService.hardDeleteTeacher();

				break;
			case 5:
				System.out.println("MENU->UpDate teacher Data By ID");
				teacherService.printTeachers();
				teacherService.updateTeacherById();

				break;
			}
		} catch (SeriaNumExceptions ex) {
			System.err.println(ex.getMessage());

		} catch (Exception ex) {
			System.err.println("bilinmeyen xeta");

		}

	}
}
