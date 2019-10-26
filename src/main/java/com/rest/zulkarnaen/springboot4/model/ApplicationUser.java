package com.rest.zulkarnaen.springboot4.model;

public class ApplicationUser {
	private String name;
	private String name2;

	public String getName() {
		return name;
	}

	public String getName2() {
		return name2;
	}

	public void setName(String name2) {
		this.name = name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Override
	public String toString() {
		return "ApplicationUser [name=" + name + " name2=" + name2 + "]";
	}
}
