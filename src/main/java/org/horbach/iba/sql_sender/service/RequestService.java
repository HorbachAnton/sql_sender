package org.horbach.iba.sql_sender.service;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Request;

public interface RequestService {

	Request getRequest(int id);

	List<Request> getRequests();

	void saveRequest(Request request);

	void updateRequest(Request request);

	void deleteRequest(Request request);

}
