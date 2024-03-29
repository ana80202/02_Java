package com.hw1.model.vo;

public class Student extends Person {
	
	private int grade;
	private String major;
	
	public Student() {}

	public Student(String name, int age, double height, double weight, int grade, String major) {
		super( age, height, weight);
		this.name = name; //Person의 protected 필드, 후손 필드는 직접접근 가능하다
		this.grade = grade;
		this.major = major;
	}
	
	
	
	@Override
	public String information() {
		return super.information() + String.format(" / 학년 : %d / 전공 : %s", grade, major);
	}



}
