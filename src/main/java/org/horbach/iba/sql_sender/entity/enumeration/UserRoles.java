package org.horbach.iba.sql_sender.entity.enumeration;

public enum UserRoles {

	ADMIN(1), USER(2);

	private final int id;

	private UserRoles(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static UserRoles getRoleById(int id) {
		return id == 1 ? UserRoles.ADMIN : UserRoles.USER;
	}

}
