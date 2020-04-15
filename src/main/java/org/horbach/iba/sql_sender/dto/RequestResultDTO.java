package org.horbach.iba.sql_sender.dto;

import java.util.Objects;

public class RequestResultDTO {

	private int id;
	private String message;

	public RequestResultDTO() {

	}

	public RequestResultDTO(int id, String message) {
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
		RequestResultDTO other = (RequestResultDTO) obj;
		return id == other.id && Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "RequestResultDTO [id=" + id + ", message=" + message + "]";
	}

}
