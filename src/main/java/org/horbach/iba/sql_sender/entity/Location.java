package org.horbach.iba.sql_sender.entity;

import java.util.Objects;

public class Location {

	private int id;
	private String title;

	public Location() {

	}

	public Location(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		return id == other.id && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", title=" + title + "]";
	}

}
