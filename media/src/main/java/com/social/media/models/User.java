package com.social.media.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long user_id;
@Column(unique = true, nullable = false)
private String username;
@Column(unique = true, nullable = false)
private String email;
@Column(nullable = false)
private String password;
@Column
private String profileImageUrl;
@Column
private String bio;

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
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getProfileImageUrl() {
return profileImageUrl;
}
public void setProfileImageUrl(String profileImageUrl) {
this.profileImageUrl = profileImageUrl;
}
public String getBio() {
return bio;
}
public void setBio(String bio) {
this.bio = bio;
}
}

