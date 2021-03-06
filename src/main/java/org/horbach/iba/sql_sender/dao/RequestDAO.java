package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.Request;
import org.horbach.iba.sql_sender.entity.RequestResult;

public interface RequestDAO {

	Request getRequest(int id);

	List<Request> getRequests();

	List<Request> getUserRequests(int userID);

	void saveRequest(Request request);

	void updateRequest(Request request);

	void deleteRequest(Request request);

	RequestResult executeRequest(Request request);

}
