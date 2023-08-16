package com.register.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Role")
@Setter
@Getter
public class Role {

	@Id
	private Integer roleId;

	private String roleName;

	private String descrpition;

	private Integer permissionId;

	private LocalDateTime createdAt;
}
