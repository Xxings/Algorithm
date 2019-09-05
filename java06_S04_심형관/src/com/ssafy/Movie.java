package com.ssafy;

public class Movie {
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String director, int grade, String genre) {
		this();
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
	}

	public Movie(String title, String director, int grade, String genre, String summary) {
		this(title,director,grade,genre);
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("영화 이름 : %10s", getTitle()));
		sb.append(String.format("\t| 영화 감독 : %10s", getDirector()));
		sb.append(String.format("\t| 영화 장르 : %10s", getGenre()));
		sb.append(String.format("\t| 영화 평점 : %2d/10", getGrade()));
		sb.append(String.format("\t| 영화 요약 : %s", getSummary()));
		return sb.toString();
	}
}
