package com.github.byference.samples.mapper;

import com.github.byference.samples.entity.UserInfo;

import java.util.List;

/**
 * @author byference
 * @since 2019/07/27
 */
public interface UserInfoMapper {

    /**
     * 获取全部 {@link UserInfo} 数据
     * @return elements of {@link UserInfo}
     */
    List<UserInfo> selectAll();


    /**
     * 可选择的新增
     * @param userInfo {@link UserInfo}
     * @return 新增成功的记录数
     */
    int insertSelective(UserInfo userInfo);

}