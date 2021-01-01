package com.sma.teachermanagmentapp.service;

import com.sma.teachermanagmentapp.model.Group;
import com.sma.teachermanagmentapp.model.Student;

public interface GroupService {
	public boolean addGroups();

	public void printGroups();

	public void softDeleteGroup();

	public void hardDeleteGroup();

	public Group getGroupById();

	public void updateGroupById();

	public void printGroup(Group group);
}
