package com.sma.teachermanagmentapp.dao;

import java.util.List;

import com.sma.teachermanagmentapp.model.Group;
import com.sma.teachermanagmentapp.model.Student;

public interface GroupDAO {
	public boolean saveGroup(Group group);

	public List<Group> getGroups();

	public boolean softDeleteGroup(Long id);

	public boolean hardDeleteGroup(Long id);

	public Group getGroupById(Long id);

	public boolean updateGroupById(Group group);
}
