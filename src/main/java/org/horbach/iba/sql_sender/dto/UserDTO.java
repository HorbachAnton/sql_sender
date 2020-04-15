package org.horbach.iba.sql_sender.dto;

import java.util.Objects;

import org.horbach.iba.sql_sender.entity.enumeration.UserRoles;

public class UserDTO {

	private int id;
	private String username;
	private String password;
	private boolean isEnabled;
	private UserRoles userRole;

	public UserDTO() {

	}

	public UserDTO(int id, String username, String password, boolean isEnabled, UserRoles userRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isEnabled = isEnabled;
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public UserRoles getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isEnabled, password, userRole, username);
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
		UserDTO other = (UserDTO) obj;
		return id == other.id && isEnabled == other.isEnabled && Objects.equals(password, other.password)
				&& userRole == other.userRole && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", isEnabled=" + isEnabled
				+ ", userRole=" + userRole + "]";
	}

}
