package org.horbach.iba.sql_sender.dao;

import org.hibernate.Session;

public interface BasicDAO {

	Session getCurrentSession();
	
	void save(Object object);
	
	void update(Object object);
	
	void delete(Object object);
	
	<T> Object getById(Class<T> expectedClass, int objectId);

}
