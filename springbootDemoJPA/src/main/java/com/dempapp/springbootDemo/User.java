package com.dempapp.springbootDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String uname;
	private String pass;
	private String city;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", pass=" + pass + ", city=" + city + "]";
	}
	public User(String uname, String pass, String city) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.city = city;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

//spring.h2.console.enabled=true
}
