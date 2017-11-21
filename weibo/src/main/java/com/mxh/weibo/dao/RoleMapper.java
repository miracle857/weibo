package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.Role;
import com.mxh.weibo.common.model.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    long countByExample(RoleExample example);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int deleteByExample(RoleExample example);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer roleId);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int insert(Role record);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int insertSelective(Role record);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    Role selectByPrimaryKey(Integer roleId);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method corresponds to the database table aa_role
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Role record);
    
    List<Role> selectRoleByUserId(String uuid);
}