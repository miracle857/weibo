package com.mxh.weibo.common.model;

import java.io.Serializable;

public class RolePermissionMapKey implements Serializable {
    /**
     * Column: aa_role_permission.ROLE_ID
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * Column: aa_role_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    private Integer permissionId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the value of aa_role_permission.ROLE_ID
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId the value for aa_role_permission.ROLE_ID
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the value of aa_role_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     *
     * @param permissionId the value for aa_role_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}