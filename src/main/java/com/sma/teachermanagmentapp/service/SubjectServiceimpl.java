package com.sma.teachermanagmentapp.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import com.sma.teachermanagmentapp.dao.SubjectDAO;
import com.sma.teachermanagmentapp.db.DbClass;
import com.sma.teachermanagmentapp.model.Group;
import com.sma.teachermanagmentapp.model.Student;
import com.sma.teachermanagmentapp.model.Subject;

public class SubjectServiceimpl implements SubjectService {
	private SubjectDAO subjectDAO;

	public SubjectServiceimpl(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	@Override
	public boolean addSubject() {
		boolean isAdded = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("add subject opp");
		System.err.println("elave edeceyiniz subject sayini daxil edin");
		int subjectCount = sc.nextInt();
		for (int i = 0; i < subjectCount; i++) {
			Subject subject = new Subject();
			System.out.println("subjectin adi ");
			subject.setSubject_name(sc.next());
			isAdded = subjectDAO.saveSubject(subject);
		}
		return isAdded;
	}

	private static Map<String, Subject> getAllSubjectsFromDB() {
		return DbClass.subjectList;
	}

	public static void printAllStudents() {
		Map<String, Subject> subjects = getAllSubjectsFromDB();
		for (Entry<String, Subject> s : subjects.entrySet()) {
			System.out.println(s.getKey() + "-" + s.getValue().getSubject_name());
		}
	}

	@Override
	public Subject getSubjectById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("subjectin id sini daxil edin");
		Subject subject = subjectDAO.getSubjectById(sc.nextLong());
		return subject;
	}

	@Override
	public void printSubject(Subject subject) {
		System.out.println(subject.getId() + "-" + subject.getSubject_name());
	}

	@Override
	public void printSubjects() {
		List<Subject> subjects = subjectDAO.getSubjects();
		for (Subject subject : subjects) {
			printSubject(subject);
		}
	}

	@Override
	public void softDeleteSubject() {
		System.err.println("silmek istediyiniz subjectin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (subjectDAO.softDeleteSubjects(id)) {
				System.out.println("subject ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void hardDeleteSubject() {
		System.err.println("silmek istediyiniz subjectin ID sini daxil edin");
		Scanner sc = new Scanner(System.in);

		try {
			Long id = sc.nextLong();
			if (subjectDAO.hardDeleteSubject(id)) {
				System.out.println("subject ugurla silindi");
			} else {
				System.out.println("xeta bash verdi");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void updateSubjectById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("deyishiklik etmek istediyiniz melumati secin");
		Subject subjectFromDb = subjectDAO.getSubjectById(sc.nextLong());
		printSubject(subjectFromDb);
		while (true) {

			System.out.println("deyishiklik etmek istediyiniz melumati secin");
			System.out.println("1.Ad\n0-Exit");
			int updateField = sc.nextInt();
			if (updateField != 0) {
				switch (updateField) {
				case 1:
					System.out.println("Yeni Ad daxil edin");
					subjectFromDb.setSubject_name(sc.next());
					break;
				}
				subjectDAO.updateSubjectById(subjectFromDb);
			} else {
				break;
			}
		}
	}
}
