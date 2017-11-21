package com.mxh.weibo.dao;

import com.mxh.weibo.common.model.RoleUserMapExample;
import com.mxh.weibo.common.model.RoleUserMapKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUserMapMapper {
    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    long countByExample(RoleUserMapExample example);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int deleteByExample(RoleUserMapExample example);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(RoleUserMapKey key);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int insert(RoleUserMapKey record);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int insertSelective(RoleUserMapKey record);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    List<RoleUserMapKey> selectByExample(RoleUserMapExample example);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") RoleUserMapKey record, @Param("example") RoleUserMapExample example);

    /**
     * This method corresponds to the database table aa_role_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") RoleUserMapKey record, @Param("example") RoleUserMapExample example);
}