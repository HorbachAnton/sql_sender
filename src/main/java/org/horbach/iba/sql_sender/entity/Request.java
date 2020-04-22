package org.horbach.iba.sql_sender.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.horbach.iba.sql_sender.entity.enumeration.RequestTypes;

public class Request {

	private int id;
	private String text;
	private RequestTypes requestType;
	private LocalDateTime executeDate;
	private User user;
	private RequestResult result;

	public Request() {

	}

	public Request(int id, String text, RequestTypes requestType, LocalDateTime executeDate, User user,
			RequestResult result) {
		super();
		this.id = id;
		this.text = text;
		this.requestType = requestType;
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

	public RequestTypes getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestTypes requestType) {
		this.requestType = requestType;
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
		return Objects.hash(executeDate, id, requestType, result, text, user);
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
		return Objects.equals(executeDate, other.executeDate) && id == other.id && requestType == other.requestType
				&& Objects.equals(result, other.result) && Objects.equals(text, other.text)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", text=" + text + ", requestTypes=" + requestType + ", executeDate=" + executeDate
				+ ", user=" + user + ", result=" + result + "]";
	}

}
