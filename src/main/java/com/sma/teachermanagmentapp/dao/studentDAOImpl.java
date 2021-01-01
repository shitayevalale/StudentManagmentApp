package com.sma.teachermanagmentapp.dao;

import com.sma.teachermanagmentapp.db.DbHelper;
import com.sma.teachermanagmentapp.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDAOImpl implements StudentDAO {
	@Override
	public boolean saveStudent(Student student) {

		boolean isAdded = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "Insert Into   student(s_name,s_surname,s_age,s_seriaNum) VALUES (?,?,?,?)";
		c = DbHelper.getconnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
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
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT s_id,s_name,s_surname,s_age,s_seriaNum FROM student WHERE active=1";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getLong("s_id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("s_surname"));
					student.setSeriaNum(rs.getString("s_seriaNum"));
					student.setAge(rs.getInt("s_age"));
					students.add(student);
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

		return students;

	}

	@Override
	public boolean softDeleteStudent(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET active=0 WHERE s_id=?";
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
	public boolean hardDeleteStudent(Long id) {
		boolean isDeleted = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM student WHERE s_id=?";
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
	public Student getStudentById(Long id) {
		Student student = new Student();
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT s_id,s_name,s_surname,s_age,s_seriaNum FROM student WHERE active=1 and s_id=?";
		try {
			c = DbHelper.getconnection();
			if (c != null) {
				ps = c.prepareStatement(sql);
				ps.setLong(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {

					student.setId(rs.getLong("s_id"));
					student.setName(rs.getString("s_name"));
					student.setSurname(rs.getString("s_surname"));
					student.setSeriaNum(rs.getString("s_seriaNum"));
					student.setAge(rs.getInt("s_age"));

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

		return student;

	}

	@Override
	public boolean updateStudentById(Student student) {
		boolean isUpdated = false;
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "UPDATE student SET s_name = ? , s_surname = ? , s_age =? , s_seriaNum = ?  WHERE s_id=?";
		c = DbHelper.getconnection();
		if (c != null) {
			try {
				ps = c.prepareStatement(sql);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSurname());
				ps.setInt(3, student.getAge());
				ps.setString(4, student.getSeriaNum());
				ps.setLong(5, student.getId());
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
