package com.register.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Permission")
@Setter
@Getter
public class Permission {

	@Id
	private Integer permissionId;

	private Boolean createUser;

	private Boolean updateUser;

	private Boolean deleteUser;

	private Boolean createRegCat;

	private Boolean updateRegCat;

	private Boolean deleteRegCat;

	private Boolean createRegEntry;

	private Boolean updateRegEntry;

	private Boolean deleteRegEntry;

	private LocalDateTime createdAt;

}
