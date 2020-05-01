package org.horbach.iba.sql_sender.entity;

import java.util.List;
import java.util.Objects;

public class RequestResult {

	private int id;
	private String message;
	private List<Object[]> requestedData;

	public RequestResult() {

	}

	public RequestResult(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public RequestResult(int id, String message, List<Object[]> requestedData) {
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

	public List<Object[]> getRequestedData() {
		return requestedData;
	}

	public void setRequestedData(List<Object[]> requestedData) {
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
		RequestResult other = (RequestResult) obj;
		return id == other.id && Objects.equals(message, other.message)
				&& Objects.equals(requestedData, other.requestedData);
	}

	@Override
	public String toString() {
		return "RequestResult [id=" + id + ", message=" + message + ", requestedData=" + requestedData + "]";
	}

}
