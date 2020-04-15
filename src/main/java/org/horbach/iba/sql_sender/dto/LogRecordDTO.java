package org.horbach.iba.sql_sender.dto;

import java.util.Objects;

import org.horbach.iba.sql_sender.entity.Request;

public class LogRecordDTO {

	private int id;
	private Request request;

	public LogRecordDTO() {

	}

	public LogRecordDTO(int id, Request request) {
		super();
		this.id = id;
		this.request = request;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, request);
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
		LogRecordDTO other = (LogRecordDTO) obj;
		return id == other.id && Objects.equals(request, other.request);
	}

	@Override
	public String toString() {
		return "LogRecordDTO [id=" + id + ", request=" + request + "]";
	}

}
