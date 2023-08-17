package com.register.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {

	@Id
	private Integer roleId;

	private String roleName;

	private String descrpition;

	private LocalDateTime createdAt;

}
