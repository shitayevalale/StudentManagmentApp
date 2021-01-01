package com.sma.teachermanagmentapp.service;

import com.sma.teachermanagmentapp.model.Subject;

public interface SubjectService {
	public boolean addSubject();

	public void printSubjects();

	public void softDeleteSubject();

	public void hardDeleteSubject();

	public Subject getSubjectById();

	public void updateSubjectById();

	public void printSubject(Subject subject);
}
