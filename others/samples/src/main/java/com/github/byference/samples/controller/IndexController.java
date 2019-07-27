package com.github.byference.samples.controller;

import com.github.byference.samples.entity.ReceiveAddress;
import com.github.byference.samples.entity.UserInfo;
import com.github.byference.samples.mapper.UserInfoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IndexController
 *
 * @author byference
 * @since 2019-07-27
 */
@RestController
@Slf4j
@AllArgsConstructor
public class IndexController {

    private final UserInfoMapper userInfoMapper;


    @RequestMapping("/user/infos")
    public List<UserInfo> userInfos() {

        return userInfoMapper.selectAll();
    }


    @RequestMapping("/user/info/insert")
    public String userInfoInsert() {

        UserInfo userInfo = new UserInfo();
        ReceiveAddress receiveAddress = new ReceiveAddress();
        receiveAddress.setDefaultAddress("北京");
        receiveAddress.setAddress1("安徽");

        userInfo.setUserName("joy");
        userInfo.setUserLevel(0);
        userInfo.setReceiveAddress(receiveAddress);

        int i = userInfoMapper.insertSelective(userInfo);
        return String.format("操作成功记录数: %s", i);
    }

}
