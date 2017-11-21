package com.mxh.weibo.common.model;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * Column: aa_role.ROLE_ID
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * Column: aa_role.ROLE_CODE
     *
     * @mbggenerated
     */
    private String roleCode;

    /**
     * Column: aa_role.ROLE_NAME
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * Column: aa_role.DELETED
     *
     * @mbggenerated
     */
    private Byte deleted;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @return the value of aa_role.ROLE_ID
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     *
     * @param roleId the value for aa_role.ROLE_ID
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the value of aa_role.ROLE_CODE
     *
     * @mbggenerated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     *
     * @param roleCode the value for aa_role.ROLE_CODE
     *
     * @mbggenerated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return the value of aa_role.ROLE_NAME
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @param roleName the value for aa_role.ROLE_NAME
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the value of aa_role.DELETED
     *
     * @mbggenerated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     *
     * @param deleted the value for aa_role.DELETED
     *
     * @mbggenerated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}