package com.sma.teachermanagmentapp.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.sma.teachermanagmentapp.dao.TeacherDAO;
import com.sma.teachermanagmentapp.db.DbClass;
import com.sma.teachermanagmentapp.model.Student;
import com.sma.teachermanagmentapp.model.Teacher;

public class TeacherServiceimpl implements TeacherService {
	private TeacherDAO teacherDAO;

	public TeacherServiceimpl(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public boolean addTeachers() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("add teacher opp");
		System.err.println("elave edeceyiniz  muellim sayini daxil edin");

		int teacherCount = sc.nextInt();
		for (int i = 0; i < teacherCount; i++) {
			Teacher teacher = new Teacher();
			System.out.println("muellimin adi ");
			teacher.setName(sc.next());
			System.out.println("muellimin soyadi ");
			teacher.setSurname(sc.next());
			System.out.println(" muellimin  yashini daxil edin");
			teacher.setAge(sc.nextInt());
			System.out.println("muellimin seriaNum");
			teacher.setSeriaNum(sc.next());
			isAdded = teacherDAO.saveTeacher(teacher);
		}
		return isAdded;
	}

	private static Map<String, Teacher> getAllTeachersFromDB() {
		return DbClass.teacherList;
	}

	public static void printAllTeacherS() {
		Map<String, Teacher> teachers = getAllTeachersFromDB();
		for (Map.Entry<String, Teacher> t : teachers.entrySet()) {
			System.out.println(t.getKey() + "-" + t.getValue().getName() + " " + t.getValue().getSurname() + " "
					+ t.getValue().getAge() + " " + t.getValue().getSeriaNum());
		}
	}

	@Override
	public Teacher getTeacherById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("muellimin id sini daxil edin");
		Teacher teacher = teacherDAO.getTeacherById(sc.nextLong());
		return teacher;
	}

	@Override
	public void updateTeacherById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("deyishiklik etmek istediyiniz melumati secin");
		Teacher teacherFromDb = teacherDAO.getTeacherById(sc.nextLong());
		printTeacher(teacherFromDb);
		while (true) {

			System.out.println("deyishiklik etmek istediyiniz melumati secin");
			System.out.println("1.Ad\n2.Soyad\n3.Yash\n4.Seria Nomresi\n0-Exit");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni Ad daxil edin");
					teacherFromDb.setName(sc.next());
					break;
				case 2:
					System.out.println("Yeni Soyad daxil edin");
					teacherFromDb.setSurname(sc.next());
					break;
				case 3:
					System.out.println("Yeni Yash daxil edin");
					teacherFromDb.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("Yeni Seria Nomresi daxil edin");
					teacherFromDb.setSeriaNum(sc.next());
					break;
				}
				teacherDAO.updateTeacherById(teacherFromDb);
			} else {
				break;
			}
		}

	}

	@Override
	public void printTeacher(Teacher teacher) {
		System.out.println(teacher.getId() + "-" + teacher.getName() + "-" + teacher.getSurname() + "-"
				+ teacher.getSeriaNum() + "-" + teacher.getAge());
	}

	@Override
	public void printTeachers() {
		List<Teacher> teachers = teacherDAO.getTeachers();
		for (Teacher teacher : teachers) {
			printTeacher(teacher);

		}

	}

	@Override
	public void softDeleteTeacher() {
		System.err.println("silmek istediyiniz muellimin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (teacherDAO.softDeleteTeacher(id)) {
				System.out.println("muellim ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteTeacher() {
		System.err.println("silmek istediyiniz muellimin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (teacherDAO.hardDeleteTeacher(id)) {
				System.out.println("muellim ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
