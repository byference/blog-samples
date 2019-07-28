package com.github.byference.samples.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.byference.samples.entity.UserInfo;
import com.github.byference.samples.mapper.UserInfoMapper;
import com.github.byference.samples.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * UserInfoServiceImpl
 *
 * @author byference
 * @since 2019-07-28
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertSelective(UserInfo userInfo) {

        int record = userInfoMapper.insertSelective(userInfo);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                List<UserInfo> userInfos = userInfoMapper.selectAll();
                log.info("after commit: {}", JSON.toJSONString(userInfos));
            }
        });
        return record;
    }

}
