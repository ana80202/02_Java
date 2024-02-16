package com.hw1.model.dto;

public abstract class Book {
	
	private String title;
	private String author;
	
	public Book() {} //기본 생성자

	//매개변수생성자
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	
	//getter/setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public String toString() {
		return title + "/"+ author;
	}
	
	
	public abstract void displayInfo(); //추상메서드가 있다 -> 추상 클래스 라는 뜻
	


}
