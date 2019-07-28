package com.github.byference.samples.service;

import com.github.byference.samples.entity.UserInfo;

import java.util.List;

/**
 * UserInfoService
 *
 * @author byference
 * @since 2019-07-28
 */
public interface UserInfoService {

    /**
     * 获取全部 {@link UserInfo} 数据
     *
     * @return elements of {@link UserInfo}
     */
    List<UserInfo> selectAll();


    /**
     * 可选择的新增
     *
     * @param userInfo {@link UserInfo}
     * @return 新增成功的记录数
     */
    int insertSelective(UserInfo userInfo);
}
