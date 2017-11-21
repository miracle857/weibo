package com.mxh.weibo.sevice;

import java.util.Set;

public interface PermissionService {

	Set<String> findPermissionByUserId(String uuid);

}
