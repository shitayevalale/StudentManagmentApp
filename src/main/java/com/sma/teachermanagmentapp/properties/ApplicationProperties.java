package com.sma.teachermanagmentapp.properties;

public class ApplicationProperties {

	private static final String MENU = " " + "***************\n" + "Menu\n" + "1.TeacherController\n"
			+ "2.StudentController\n" + "3.GroupController\n" + "4.SubjectController\n" + "*************";
	private static final String MENU1 = " " + "Menu1\n" + "1.Add Teacher\n" + "2.Get Teachers\n"
			+ "3.Soft Delete Teacher\n" + "4.Hard Delete Teacher\n" + "5.UpDate Teacher By ID\n" + "*************";

	private static final String MENU2 = " " + "Menu2\n" + "1.Add Student\n" + "2.Get Students\n"
			+ "3.Hard Delete Student\n" + "4.Soft Delete Student\n" + "5.UpDate Student By Id\n" + "*************";

	private static final String MENU3 = " " + "Menu3\n" + "1.Add Group\n" + "2.Get Group\n" + "3.Soft Delete Group\n"
			+ "4.Hard Delete group\n" + "1.UpDate Group By ID\n" + "*************";
	private static final String MENU4 = " " + "Menu4\n" + "1.Add Subject\n" + "2.Get Subject\n"
			+ "3.Soft Delete Subject\n" + "4.Hard Delete Subject\n" + "5.UpDate Subject By ID\n" + "*************";

	private static final String SERIA_NUM_EXCEPTÝON = "daxil etdiyiniz melumat 7 simvoldan ibaret olmalidir";

	public static String getSeriaNumExceptionMessage() {
		return SERIA_NUM_EXCEPTÝON;
	}

	public static void printMenu() {
		System.out.println(MENU);
	}

	public static void printMenu1() {
		System.out.println(MENU1);
	}

	public static void printMenu2() {
		System.out.println(MENU2);
	}

	public static void printMenu3() {
		System.out.println(MENU3);
	}

	public static void printMenu4() {
		System.out.println(MENU4);
	}

}
