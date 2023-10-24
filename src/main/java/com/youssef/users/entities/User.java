package com.youssef.users.entities;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long user_id;
@Column(unique=true)
private String username;
private String email;
private String password;
private Boolean enabled;
 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,
 inverseJoinColumns = @JoinColumn(name="role_id"))
private List<Role> roles;


public Long getUser_id() {
	return user_id;
}
public void setUser_id(Long user_id) {
	this.user_id = user_id;
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
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 
}
