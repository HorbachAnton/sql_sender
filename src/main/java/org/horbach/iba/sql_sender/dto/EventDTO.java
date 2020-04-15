package org.horbach.iba.sql_sender.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import org.horbach.iba.sql_sender.entity.Location;

public class EventDTO {

	private int id;
	private String title;
	private String summary;
	private LocalDateTime date;
	private Location location;
	private int price;

	public EventDTO() {

	}

	public EventDTO(int id, String title, String summary, LocalDateTime date, Location location, int price) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.date = date;
		this.location = location;
		this.price = price;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, location, price, summary, title);
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
		EventDTO other = (EventDTO) obj;
		return Objects.equals(date, other.date) && id == other.id && Objects.equals(location, other.location)
				&& price == other.price && Objects.equals(summary, other.summary) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", summary=" + summary + ", date=" + date + ", location="
				+ location + ", price=" + price + "]";
	}

}
