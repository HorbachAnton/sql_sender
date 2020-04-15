package org.horbach.iba.sql_sender.dto;

import java.util.Objects;

import org.horbach.iba.sql_sender.entity.Event;
import org.horbach.iba.sql_sender.entity.User;

public class TicketDTO {

	private int id;
	private User user;
	private Event event;

	public TicketDTO() {

	}

	public TicketDTO(int id, User user, Event event) {
		super();
		this.id = id;
		this.user = user;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int hashCode() {
		return Objects.hash(event, id, user);
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
		TicketDTO other = (TicketDTO) obj;
		return Objects.equals(event, other.event) && id == other.id && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "TicketDTO [id=" + id + ", user=" + user + ", event=" + event + "]";
	}

}
