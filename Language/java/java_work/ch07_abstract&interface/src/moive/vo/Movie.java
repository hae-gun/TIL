package moive.vo;

import moive.m_enum.Genre;

//Movie class : (String) title, (String) isbn, (String-enum) genre, nation, director, actor...
public class Movie {

	private String title;
	private String isbn;
	private Genre genre;
	private Actor[] actors = new Actor[20];

	public Movie(String title, String isbn, Genre genre) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Actor[] getActors() {
		return actors;
	}

	public void setActors(Actor[] actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", isbn=" + isbn + ", genre=" + genre + "]";
	}

}
