package com.sma.teachermanagmentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sma.teachermanagmentapp.db.DbHelper;
import com.sma.teachermanagmentapp.model.Student;
import com.sma.teachermanagmentapp.model.Teacher;

public class teacherDAOImpl implements TeacherDAO {
	@Override
	public boolean saveTeacher(Teacher teacher) {
		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "Insert Into  teacher(t_name,t_surname,t_age,t_seriaNum) VALUES (?,?,?,?)";
		c = DbHelper.getconnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, teacher.getName());
				ps.setString(2, teacher.getSurname());
				ps.setInt(3, teacher.getAge());
				ps.setString(4, teacher.getSeriaNum());
				ps.execute();
				isAdded = true;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			} finally {
				try {
					ps.close();
					c.close();
				} catch (SQLException ex) {
					System.err.println(ex.getMessage());

				}
			}
		}
		return isAdded;
	}

	@Override
	public List<Teacher> getTeachers() {
		List<Teacher> teachers = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT t_id,t_name,t_surname,t_age,t_seriaNum FROM teacher WHERE active=1";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setId(rs.getLong("t_id"));
					teacher.setName(rs.getString("t_name"));
					teacher.setSurname(rs.getString("t_surname"));
					teacher.setSeriaNum(rs.getString("t_seriaNum"));
					teacher.setAge(rs.getInt("t_age"));
					teachers.add(teacher);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());

			}
		}

		return teachers;

	}

	@Override
	public boolean softDeleteTeacher(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE teacher SET active=0 WHERE t_id=?";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
		}
		return isDeleted;

	}

	@Override
	public boolean hardDeleteTeacher(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM teacher WHERE t_id=?";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				isDeleted = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
		}
		return isDeleted;

	}

	@Override
	public Teacher getTeacherById(Long id) {
		Teacher teacher = new Teacher();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT t_id,t_name,t_surname,t_age,t_seriaNum FROM teacher WHERE active=1";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {

					teacher.setId(rs.getLong("t_id"));
					teacher.setName(rs.getString("t_name"));
					teacher.setSurname(rs.getString("t_surname"));
					teacher.setSeriaNum(rs.getString("t_seriaNum"));
					teacher.setAge(rs.getInt("t_age"));

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ps.close();
				c.close();
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());

			}
		}
		return teacher;
	}

	@Override
	public boolean updateTeacherById(Teacher teacher) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE teacher SET t_name = ? , t_surname = ? , t_age =? , t_seriaNum = ?  WHERE t_id=?";
		c = DbHelper.getconnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, teacher.getName());
				ps.setString(2, teacher.getSurname());
				ps.setInt(3, teacher.getAge());
				ps.setString(4, teacher.getSeriaNum());
				ps.setLong(5, teacher.getId());
				ps.execute();
				isUpdated = true;
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			} finally {
				try {
					ps.close();
					c.close();
				} catch (SQLException ex) {
					System.err.println(ex.getMessage());

				}
			}
		}
		return isUpdated;
	}
}