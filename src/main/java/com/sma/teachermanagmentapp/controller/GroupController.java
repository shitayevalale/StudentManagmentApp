package com.sma.teachermanagmentapp.controller;

import java.util.Scanner;

import com.sma.teachermanagmentapp.dao.GroupDAO;
import com.sma.teachermanagmentapp.dao.groupDAOImpl;
import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;
import com.sma.teachermanagmentapp.service.GroupService;
import com.sma.teachermanagmentapp.service.GroupServiceimpl;

public class GroupController {
	public static void groupController() throws Exception {
		Scanner sc = new Scanner(System.in);
		GroupDAO groupDAO = new groupDAOImpl();
		GroupService groupService = new GroupServiceimpl(groupDAO);
		ApplicationProperties.printMenu3();
		int selectedOperation = sc.nextInt();
		try {
			switch (selectedOperation) {
			case 1:
				System.out.println("MENU->add group list");
				groupService.addGroups();

				break;
			case 2:
				System.out.println("MENU->Get group list");
				groupService.printGroups();

				break;
			case 3:
				System.out.println("MENU->Get softDelete group By ID");
				groupService.printGroups();
				groupService.softDeleteGroup();

				break;
			case 4:
				System.out.println("MENU->Get hardDelete group By ID");
				groupService.printGroups();
				groupService.hardDeleteGroup();

				break;
			case 5:
				System.out.println("MENU->UpDate group Data By ID");
				groupService.printGroups();
				groupService.updateGroupById();

				break;

			}
		} catch (SeriaNumExceptions ex) {
			System.err.println(ex.getMessage());

		} catch (Exception ex) {
			System.err.println("bilinmeyen xeta");

		}

	}
}
