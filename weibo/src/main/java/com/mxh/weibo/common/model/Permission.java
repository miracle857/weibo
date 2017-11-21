package com.mxh.weibo.common.model;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     * Column: aa_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    private Integer permissionId;

    /**
     * Column: aa_permission.PERMISSION_CODE
     *
     * @mbggenerated
     */
    private String permissionCode;

    /**
     * Column: aa_permission.PERMISSION_NAME
     *
     * @mbggenerated
     */
    private String permissionName;

    /**
     * Column: aa_permission.IS_PUBLIC
     *
     * @mbggenerated
     */
    private Byte isPublic;

    /**
     * Column: aa_permission.DELETED
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
     * @return the value of aa_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     *
     * @param permissionId the value for aa_permission.PERMISSION_ID
     *
     * @mbggenerated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * @return the value of aa_permission.PERMISSION_CODE
     *
     * @mbggenerated
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     *
     * @param permissionCode the value for aa_permission.PERMISSION_CODE
     *
     * @mbggenerated
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * @return the value of aa_permission.PERMISSION_NAME
     *
     * @mbggenerated
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     *
     * @param permissionName the value for aa_permission.PERMISSION_NAME
     *
     * @mbggenerated
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * @return the value of aa_permission.IS_PUBLIC
     *
     * @mbggenerated
     */
    public Byte getIsPublic() {
        return isPublic;
    }

    /**
     *
     * @param isPublic the value for aa_permission.IS_PUBLIC
     *
     * @mbggenerated
     */
    public void setIsPublic(Byte isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * @return the value of aa_permission.DELETED
     *
     * @mbggenerated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     *
     * @param deleted the value for aa_permission.DELETED
     *
     * @mbggenerated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}