package com.sma.teachermanagmentapp.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.sma.teachermanagmentapp.dao.StudentDAO;
import com.sma.teachermanagmentapp.db.DbClass;
import com.sma.teachermanagmentapp.model.Student;

public class StudentServiceimpl implements StudentService {
	private StudentDAO studentDAO;

	public StudentServiceimpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public boolean addStudents() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("add  student opp");
		System.err.println("elave edeceyiniz telebe sayini daxil edin");
		int studentCount = sc.nextInt();
		for (int i = 0; i < studentCount; i++) {
			Student student = new Student();
			System.out.println("telebenin adi ");
			student.setName(sc.next());
			System.out.println("telebenin soyadi ");
			student.setSurname(sc.next());
			System.out.println(" telebenin  yashini daxil edin");
			student.setAge(sc.nextInt());
			System.out.println("telebenin seriaNum");
			student.setSeriaNum(sc.next());
			isAdded = studentDAO.saveStudent(student);
		}
		return isAdded;
	}

	private static Map<String, Student> getAllStudentsFromDB() {
		return DbClass.studentList;
	}

	public static void printAllStudents() {
		Map<String, Student> students = getAllStudentsFromDB();
		for (Map.Entry<String, Student> s : students.entrySet()) {
			System.out.println(s.getKey() + "-" + s.getValue().getName() + " " + s.getValue().getSurname() + " "
					+ s.getValue().getAge() + " " + s.getValue().getSeriaNum());
		}
	}

	@Override
	public Student getStudentById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("telebenin id sini daxil edin");
		Student student = studentDAO.getStudentById(sc.nextLong());
		return student;
	}

	@Override
	public void updateStudentById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("deyishiklik etmek istediyiniz melumati secin");
		Student studentFromDb = studentDAO.getStudentById(sc.nextLong());
		printStudent(studentFromDb);

		while (true) {

			System.out.println("deyishiklik etmek istediyiniz melumati secin");
			System.out.println("1.Ad\n2.Soyad\n3.Yash\n4.Seria Nomresi\n0.EXIT");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni Ad daxil edin");
					studentFromDb.setName(sc.next());
					break;
				case 2:
					System.out.println("Yeni Soyad daxil edin");
					studentFromDb.setSurname(sc.next());
					break;
				case 3:
					System.out.println("Yeni Yash daxil edin");
					studentFromDb.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("Yeni Seria Nomresi daxil edin");
					studentFromDb.setSeriaNum(sc.next());
					break;
				}
				studentDAO.updateStudentById(studentFromDb);
			} else {
				break;
			}
		}
	}

	@Override
	public void printStudent(Student student) {
		System.out.println(student.getId() + "-" + student.getName() + "-" + student.getSurname() + "-"
				+ student.getSeriaNum() + "-" + student.getAge());
	}

	@Override
	public void printStudents() {
		List<Student> students = studentDAO.getStudents();
		for (Student student : students) {
			printStudent(student);
		}

	}

	@Override
	public void softDeleteStudent() {
		System.err.println("silmek istediyiniz telebenin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (studentDAO.softDeleteStudent(id)) {
				System.out.println("telebe ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteStudent() {
		System.err.println("silmek istediyiniz telebenin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (studentDAO.hardDeleteStudent(id)) {
				System.out.println("telebe ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
