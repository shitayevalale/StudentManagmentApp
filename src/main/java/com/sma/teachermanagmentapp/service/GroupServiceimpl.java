package com.sma.teachermanagmentapp.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sma.teachermanagmentapp.dao.GroupDAO;
import com.sma.teachermanagmentapp.db.DbClass;
import com.sma.teachermanagmentapp.model.Group;
import com.sma.teachermanagmentapp.model.Student;

public class GroupServiceimpl implements GroupService {
	private GroupDAO groupDAO;

	public GroupServiceimpl(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	@Override
	public boolean addGroups() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("add group opp");
		System.err.println("elave edeceyiniz group sayini daxil edin");
		int groupCount = sc.nextInt();
		for (int i = 0; i < groupCount; i++) {
			Group group = new Group();
			System.out.println("grupun adi ");
			group.setGroup_name(sc.next());
			isAdded = groupDAO.saveGroup(group);
		}
		return isAdded;
	}

	private static Map<String, Group> getAllGroupsFromDB() {
		return DbClass.groupList;
	}

	public static void printAllGroups() {
		Map<String, Group> groups = getAllGroupsFromDB();
		for (Map.Entry<String, Group> g : groups.entrySet()) {
			System.out.println(g.getKey() + "-" + g.getValue().getGroup_name());
		}
	}

	@Override
	public Group getGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("groupun id sini daxil edin");
		Group group = groupDAO.getGroupById(sc.nextLong());
		return group;
	}

	@Override
	public void printGroup(Group group) {
		System.out.println(group.getId() + "-" + group.getGroup_name());
	}

	@Override
	public void printGroups() {
		List<Group> groups = groupDAO.getGroups();
		for (Group group : groups) {
			printGroup(group);
		}
	}

	@Override
	public void softDeleteGroup() {
		System.err.println("silmek istediyiniz groupun ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (groupDAO.softDeleteGroup(id)) {
				System.out.println("group ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteGroup() {
		System.err.println("silmek istediyiniz groupun ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (groupDAO.hardDeleteGroup(id)) {
				System.out.println("group ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateGroupById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("deyishiklik etmek istediyiniz melumati secin");
		Group groupFromDb = groupDAO.getGroupById(sc.nextLong());
		printGroup(groupFromDb);
		while (true) {

			System.out.println("deyishiklik etmek istediyiniz melumati secin");
			System.out.println("1.Ad\n0-Exit ");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni Ad daxil edin");
					groupFromDb.setGroup_name(sc.next());
					break;

				}
				groupDAO.updateGroupById(groupFromDb);
			} else {
				break;
			}
		}
	}
}
