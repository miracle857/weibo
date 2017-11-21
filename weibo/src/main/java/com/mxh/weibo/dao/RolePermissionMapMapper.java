package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.RolePermissionMapExample;
import com.mxh.weibo.common.model.RolePermissionMapKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionMapMapper {
    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    long countByExample(RolePermissionMapExample example);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int deleteByExample(RolePermissionMapExample example);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(RolePermissionMapKey key);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int insert(RolePermissionMapKey record);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int insertSelective(RolePermissionMapKey record);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    List<RolePermissionMapKey> selectByExample(RolePermissionMapExample example);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RolePermissionMapKey record, @Param("example") RolePermissionMapExample example);

    /**
     * This method corresponds to the database table aa_role_permission
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RolePermissionMapKey record, @Param("example") RolePermissionMapExample example);
}