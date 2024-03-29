package edu.kh.collection.model.vo;

public class Student {

	// 필드
	private String name;
	private int age;
	private String region;
	private char gender;
	private int score;
	
	//기본 생성자
	public Student() {}

	//매개변수 생성자
	public Student(String name, int age, String region, char gender, int score) {
		super(); //부모클래스에서는 딱히 없어도 된다
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.score = score;
	}

	//getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	//toString()오버라이딩
	// alt + shift + s -> (Generate toString...) -> 엔터
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", score="
				+ score + "]";
	}
	
}
