package com.register.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User")
@Setter
@Getter
public class User {

	@Id
	private Integer userId;

	private String username;

	private String password;

	private Integer roleId;

	private LocalDateTime createdAt;

}
