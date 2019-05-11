package com.github.byference.samples.service.impl;

import com.github.byference.samples.entity.Account;
import com.github.byference.samples.entity.Turnover;
import com.github.byference.samples.mapper.TransactionalMapper;
import com.github.byference.samples.service.TransactionalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Random;

/**
 * default {@link TransactionalService} implementation
 *
 * @author byference
 * @since 2019/05/11
 */
@Service
@AllArgsConstructor
public class TransactionalServiceImpl implements TransactionalService {

    private final TransactionalMapper transactionalMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transfer(Turnover turnover) {

        // 0、假设金额都够，不做校验
        Assert.notNull(turnover, "转账接口参数不能为空");

        // 1、转出方扣除交易金额
        Account transferor = new Account();
        transferor.setUserName(turnover.getTransferor());
        transferor.setAccount(turnover.getAmount());
        transactionalMapper.transferor(transferor);

        // 2、模拟异常
        this.error();

        // 3、转入方增加交易金额
        Account transferee = new Account();
        transferee.setUserName(turnover.getTransferee());
        transferee.setAccount(turnover.getAmount());
        transactionalMapper.transferee(transferee);

        // 4、记录流水(这里失败做回滚处理)
        turnover.setDate(new Date());
        transactionalMapper.insertTurnover(turnover);
    }


    /**
     * 模拟异常
     */
    private void error() {

        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("网络中断");
        }
    }


}
