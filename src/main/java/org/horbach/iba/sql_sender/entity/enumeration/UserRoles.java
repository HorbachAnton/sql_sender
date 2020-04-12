package org.horbach.iba.sql_sender.entity.enumeration;

import java.util.Arrays;

public enum UserRoles {

	ADMIN(1), USER(2), UNDEFINED(3);

	private final int id;

	private UserRoles(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static UserRoles getRoleById(int id) {
		return Arrays.stream(UserRoles.values()).filter(role -> role.getId() == id).findFirst()
				.orElse(UserRoles.UNDEFINED);
	}

}
