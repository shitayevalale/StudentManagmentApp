package com.sma.teachermanagmentapp.controller;

import java.util.Scanner;

import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;

public class GeneralController {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ApplicationProperties.printMenu();
		int controller = sc.nextInt();
		try {
			switch (controller) {
			case 1:
				System.out.println("MENU->teacher controller");
				TeacherController.teacherController();
				main(args);
				break;
			case 2:
				System.out.println("MENU->student controller");
				StudentController.studentController();
				main(args);
				break;
			case 3:
				System.out.println("MENU->group controller");
				GroupController.groupController();
				main(args);
				break;
			case 4:
				System.out.println("MENU->subject controller");
				SubjectController.subjectController();
				main(args);
				break;

			}
		} catch (SeriaNumExceptions ex) {
			System.err.println(ex.getMessage());
			main(args);
		} catch (Exception ex) {
			System.err.println("bilinmeyen xeta");
			main(args);
		}

	}
}
