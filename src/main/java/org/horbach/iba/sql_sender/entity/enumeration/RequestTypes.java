package org.horbach.iba.sql_sender.entity.enumeration;

import java.util.Arrays;

public enum RequestTypes {

	UNDEFINED(0), SELECT(1), UPDATE(2), INSERT(3), DELETE(4), CREATE(5), DROP(6);

	private final int id;

	private RequestTypes(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static RequestTypes getTypeById(int id) {
		return Arrays.stream(RequestTypes.values()).filter(role -> role.getId() == id).findFirst()
				.orElse(RequestTypes.UNDEFINED);
	}

}
