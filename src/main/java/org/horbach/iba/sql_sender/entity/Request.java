package org.horbach.iba.sql_sender.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Request {

	private int id;
	private String text;
	private LocalDateTime executeDate;
	private User user;
	private RequestResult result;

	public Request() {

	}

	public Request(int id, String text, LocalDateTime executeDate, User user, RequestResult result) {
		super();
		this.id = id;
		this.text = text;
		this.executeDate = executeDate;
		this.user = user;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(LocalDateTime executeDate) {
		this.executeDate = executeDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RequestResult getResult() {
		return result;
	}

	public void setResult(RequestResult result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(executeDate, id, result, text, user);
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
		Request other = (Request) obj;
		return Objects.equals(executeDate, other.executeDate) && id == other.id && Objects.equals(result, other.result)
				&& Objects.equals(text, other.text) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", text=" + text + ", executeDate=" + executeDate + ", user=" + user + ", result="
				+ result + "]";
	}

}
