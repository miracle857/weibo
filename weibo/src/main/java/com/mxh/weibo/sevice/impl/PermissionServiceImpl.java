package com.mxh.weibo.sevice.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.model.Permission;
import com.mxh.weibo.dao.PermissionMapper;
import com.mxh.weibo.sevice.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public Set<String> findPermissionByUserId(String uuid) {
		List<Permission> list = permissionMapper.selectPermissionByUserId(uuid);
		Set<String> set = new HashSet<>();
		for (Permission permission : list) {
			set.add(permission.getPermissionName());
		}
		return set;
	}

}
