package com.sma.teachermanagmentapp.model;

import com.sma.teachermanagmentapp.exception.SeriaNumExceptions;
import com.sma.teachermanagmentapp.properties.ApplicationProperties;

public class Person {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String seriaNum;
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			this.age = Math.abs(age);
		} else {
			this.age = age;
		}

	}

	public String getSeriaNum() {
		return seriaNum;
	}

	public void setSeriaNum(String seriaNum) {
		if (seriaNum.length() == 7) {
			this.seriaNum = seriaNum;
		} else {
			throw new SeriaNumExceptions(ApplicationProperties.getSeriaNumExceptionMessage());

		}

	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
