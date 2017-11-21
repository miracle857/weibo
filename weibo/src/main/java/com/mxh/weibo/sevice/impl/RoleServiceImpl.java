package com.mxh.weibo.sevice.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxh.weibo.common.model.Role;
import com.mxh.weibo.dao.RoleMapper;
import com.mxh.weibo.sevice.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Set<String> findRoleNameByUserId(String uuid) {
		List<Role> list = roleMapper.selectRoleByUserId(uuid);
		Set<String> set = new HashSet<>();
		for (Role role : list) {
			set.add(role.getRoleName());
		}
		return set;
	}

}
