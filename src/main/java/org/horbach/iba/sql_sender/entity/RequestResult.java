package org.horbach.iba.sql_sender.entity;

import java.util.Objects;

public class RequestResult {

	private int id;
	private String message;

	public RequestResult() {

	}

	public RequestResult(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message);
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
		RequestResult other = (RequestResult) obj;
		return id == other.id && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "RequestResult [id=" + id + ", message=" + message + "]";
	}

}
