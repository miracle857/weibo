package com.mxh.weibo.sevice;

import java.util.Set;


public interface RoleService {

	 Set<String> findRoleNameByUserId(String uuid);
}
