package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.Permission;
import com.mxh.weibo.common.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    long countByExample(PermissionExample example);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer permissionId);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int insert(Permission record);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int insertSelective(Permission record);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    Permission selectByPrimaryKey(Integer permissionId);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method corresponds to the database table aa_permission
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Permission record);
    
    List<Permission> selectPermissionByUserId(String uuid);
}