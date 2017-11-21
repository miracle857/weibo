package com.mxh.weibo.common.model;

import java.io.Serializable;

public class RoleUserMapKey implements Serializable {
    /**
     * Column: aa_role_user.ROLE_ID
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * Column: aa_role_user.USER_ID
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the value of aa_role_user.ROLE_ID
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId the value for aa_role_user.ROLE_ID
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the value of aa_role_user.USER_ID
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId the value for aa_role_user.USER_ID
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}