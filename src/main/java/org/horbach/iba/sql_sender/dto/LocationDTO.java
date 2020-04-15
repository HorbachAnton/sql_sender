package org.horbach.iba.sql_sender.dto;

import java.util.Objects;

public class LocationDTO {

	private int id;
	private int title;

	public LocationDTO() {

	}

	public LocationDTO(int id, int title) {
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

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
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
		LocationDTO other = (LocationDTO) obj;
		return id == other.id && title == other.title;
	}

	@Override
	public String toString() {
		return "LocationDTO [id=" + id + ", title=" + title + "]";
	}

}
