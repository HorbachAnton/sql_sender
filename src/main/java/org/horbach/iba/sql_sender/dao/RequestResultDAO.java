package org.horbach.iba.sql_sender.dao;

import java.util.List;

import org.horbach.iba.sql_sender.entity.RequestResult;

public interface RequestResultDAO {

	RequestResult getRequestResult(int id);

	List<RequestResult> getRequestResult();

	void saveRequestResult(RequestResult requestResult);

	void updateRequestResult(RequestResult requestResult);

	void deleteRequestResult(RequestResult requestResult);

}
