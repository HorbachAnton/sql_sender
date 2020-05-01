package org.horbach.iba.sql_sender.dto;

import java.util.List;
import java.util.Objects;

public class RequestResultDTO {

	private int id;
	private String message;
	private List<String[]> requestedData;

	public RequestResultDTO() {

	}

	public RequestResultDTO(int id, String message, List<String[]> requestedData) {
		super();
		this.id = id;
		this.message = message;
		this.requestedData = requestedData;
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

	public List<String[]> getRequestedData() {
		return requestedData;
	}

	public void setRequestedData(List<String[]> requestedData) {
		this.requestedData = requestedData;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, message, requestedData);
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
		return id == other.id && Objects.equals(message, other.message)
				&& Objects.equals(requestedData, other.requestedData);
	}

	@Override
	public String toString() {
		return "RequestResultDTO [id=" + id + ", message=" + message + ", requestedData=" + requestedData + "]";
	}

}
