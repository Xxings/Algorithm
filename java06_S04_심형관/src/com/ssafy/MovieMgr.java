package com.ssafy;

public class MovieMgr {
	static MovieMgr mgr = new MovieMgr();
	private Movie[] movies = new Movie[100];
	private int index = 0;
	private int size = 0;
	private Movie[] dataset;

	public MovieMgr MovieMgr() {
		// TODO Auto-generated constructor stub

		return mgr;
	}

	public void add(Movie m) {
		movies[index++]=m;
		this.setSize(this.getSize() + 1);
	}

	public Movie[] search() {
		dataset = new Movie[100];
		dataset = movies;
		return dataset;
	}

	public Movie[] search(String title) {
		dataset = new Movie[100];
		int idx = 0;
		for(Movie data : movies) {
			if(data == null) {continue;}
			if(data.getTitle().contains(title)) {
				dataset[idx++] = data;
			}
		}
		return dataset;
	}

	public Movie[] searchDirectior(String name) {
		dataset = new Movie[100];

		return dataset;
	}

	public Movie[] searchGenre(String gerne) {
		dataset = new Movie[100];
		int idx = 0;
		for(Movie data : movies) {
			if(data == null) {continue;}
			if(data.getGenre().contains(gerne)) {
				dataset[idx++] = data;
			}
		}
		return dataset;
	}

	public void delete(String title) {
		for (int i = 0; i < movies.length; i++) {
			Movie data = movies[i];
			if(data == null) { continue; }
			else if(data.getTitle().equals(title)) {
				movies[i] = null;
				setSize(getSize()-1);
			}
		}
	}

	public int getSize() {
		return this.size;
	}

	final private void setSize(int size) {
		this.size = size;
	}
}
