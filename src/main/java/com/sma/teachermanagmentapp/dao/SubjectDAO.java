package com.sma.teachermanagmentapp.dao;

import java.util.List;

import com.sma.teachermanagmentapp.model.Subject;

public interface SubjectDAO {
	public boolean saveSubject(Subject subject);

	public List<Subject> getSubjects();

	public boolean softDeleteSubjects(Long id);

	public boolean hardDeleteSubject(Long id);

	public Subject getSubjectById(Long id);

	public boolean updateSubjectById(Subject subject);
}
