package it.uniroma3.siw.GameHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
public class Credentials {

	public static final String ROLE_DEFAULT = "DEFAULT";
	public static final String ROLE_ADMIN = "ADMIN";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotBlank
	private String username;
	private String password;
	private String role;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public String getUsername() {
		return username;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isGuest() {
		return !this.role.equals(ROLE_ADMIN) && !this.role.equals(ROLE_DEFAULT);
	}
	
	public boolean isDefault() {
		return this.role.equals(ROLE_DEFAULT);
	}
	
	public boolean isAdmin() {
		return this.role.equals(ROLE_ADMIN);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Credentials))
			return false;
		Credentials other = (Credentials) obj;
		return Objects.equals(username, other.username);
	}
	
}
