package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Request;

public interface RequestDAO {

	Request getRequest(int id);

	List<Request> getRequest();

	void saveRequest(Request request);

	void updateRequest(Request request);

	void deleteRequest(Request request);

}
