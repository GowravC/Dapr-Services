package com.register.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.register.repository.RoleRepository;
import com.register.repository.UserRepository;

/**
 * 
 * @author supriya.handiavar
 *
 */
@Component
public class Helper {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public int genrateUserId() {
		if (userRepository.getUserId() != null) {
			int genUserId = userRepository.getUserId();
			genUserId++;
			return genUserId;
		}
		return 1000;
	}

	public int genrateRoleId() {
		if (roleRepository.getRoleId() != null) {
			int genRoleId = roleRepository.getRoleId();
			genRoleId++;
			return genRoleId;
		}
		return 2000;

	}

//	public int genratePermissionId() {
//		if (perRepository.getPermissionId() != null) {
//			int genPerId = perRepository.getPermissionId();
//			genPerId++;
//			return genPerId;
//		}
//		return 3000;
//	}

}
