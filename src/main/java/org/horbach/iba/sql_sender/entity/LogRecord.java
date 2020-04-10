package org.horbach.iba.sql_sender.entity;

import java.util.Objects;

public class LogRecord {

	private int id;
	private Request request;

	public LogRecord() {

	}

	public LogRecord(int id, Request request) {
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
		LogRecord other = (LogRecord) obj;
		return id == other.id && Objects.equals(request, other.request);
	}

	@Override
	public String toString() {
		return "LogRecord [id=" + id + ", request=" + request + "]";
	}

}
