package com.sma.teachermanagmentapp.db;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.sql.SQLException;
import java.sql.Connection;

public class DbHelper {
	public static Connection getconnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/studentmanagmentapp?serverTimezone=UTC";
			String user = "root";
			String password = "mysql";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			if (con != null) {
				System.out.println("ok");
			} else {
				System.out.println("not ok");
			}

			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;
	}
}