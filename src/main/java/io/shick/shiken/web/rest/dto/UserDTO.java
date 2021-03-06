package io.shick.shiken.web.rest.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class UserDTO {

	public static final int PASSWORD_MIN_LENGTH = 5;
	public static final int PASSWORD_MAX_LENGTH = 100;

	@Pattern(regexp = "^[a-z0-9]*$")
	@NotNull
	@Size(min = 1, max = 50)
	private String login;

	@NotNull
	@Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
	private String password;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 100)
	private String email;

	@Size(min = 2, max = 5)
	private String langKey;

	private List<String> roles;

	public UserDTO() {
	}

	public UserDTO(String login, String password, String firstName, String lastName, String email, String langKey,
			List<String> roles) {
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.langKey = langKey;
		this.roles = roles;
	}

	public String getGravatarImageUrl() {
		String email = getEmail();
		String hash = MD5Util.md5Hex(email);
		return "http://www.gravatar.com/avatar/" + hash;
	}

	public String getPassword() {
		return password;
	}

	public String getLogin() {
		return login;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getLangKey() {
		return langKey;
	}

	public List<String> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public boolean equals(Object other) {
		return Pojomatic.equals(this, other);
	}
}
