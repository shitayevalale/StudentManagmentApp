package com.sma.teachermanagmentapp.controller;

import java.util.Scanner;

import com.sma.teachermanagmentapp.dao.SubjectDAO;
import com.sma.teachermanagmentapp.dao.subjectDAOImpl;
import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;
import com.sma.teachermanagmentapp.service.SubjectService;
import com.sma.teachermanagmentapp.service.SubjectServiceimpl;

public class SubjectController {
	public static void subjectController() throws Exception {
		Scanner sc = new Scanner(System.in);
		SubjectDAO subjectDAO = new subjectDAOImpl();
		SubjectService subjectService = new SubjectServiceimpl(subjectDAO);
		ApplicationProperties.printMenu4();
		int selectedOperation = sc.nextInt();
		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("MENU->add subject list");
				subjectService.addSubject();

				break;
			case 2:
				System.out.println("MENU->Get subject list");
				subjectService.printSubjects();

				break;
			case 3:
				System.out.println("MENU->Get softDelete subject By ID");
				subjectService.printSubjects();
				subjectService.softDeleteSubject();

				break;
			case 4:
				System.out.println("MENU->Get hardDelete subject By ID");
				subjectService.printSubjects();
				subjectService.hardDeleteSubject();

				break;
			case 5:
				System.out.println("MENU->UpDAte subject Data By ID");
				subjectService.printSubjects();
				subjectService.updateSubjectById();

				break;
			}
		} catch (SeriaNumExceptions ex) {
			System.err.println(ex.getMessage());

		} catch (Exception ex) {
			System.err.println("bilinmeyen xeta");

		}

	}
}
