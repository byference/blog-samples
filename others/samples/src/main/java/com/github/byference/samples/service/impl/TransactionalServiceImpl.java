package com.github.byference.samples.service.impl;

import com.github.byference.samples.entity.Account;
import com.github.byference.samples.entity.Turnover;
import com.github.byference.samples.mapper.TransactionalMapper;
import com.github.byference.samples.service.TransactionalService;
import com.github.byference.samples.service.TurnoverService;
import com.github.byference.samples.utils.ExceptionUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

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

    private final TurnoverService turnoverService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transfer(Turnover turnover) {

        // 1、假设金额都够，不做校验
        Assert.notNull(turnover, "转账接口参数不能为空");

        // 2、转出方扣除交易金额
        Account transferor = new Account();
        transferor.setUserName(turnover.getTransferor());
        transferor.setAccount(turnover.getAmount());
        transactionalMapper.transferor(transferor);

        // 3、转入方增加交易金额
        Account transferee = new Account();
        transferee.setUserName(turnover.getTransferee());
        transferee.setAccount(turnover.getAmount());
        transactionalMapper.transferee(transferee);

        // 4、记录流水(这里失败做回滚处理)
        turnoverService.insertTurnover(turnover);

        // 5、模拟异常
        ExceptionUtil.error();
    }


    /**
     * 记录流水
     *
     * 这里如果直接由 {@link #transfer} 调用，就算使用 {@link Transactional} 注解，
     * 设置 {@link Propagation#REQUIRES_NEW} 也不会创建新事务，因为不是经由代理对象调用
     * 即记录流水操作会被回滚.
     * 想要回滚可以使用 {@link TurnoverServiceImpl#insertTurnover} 方式
     * @param turnover 流水实体{@link Turnover}
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void insertTurnover(Turnover turnover) {
        // 记录流水
        turnover.setDate(new Date());
        transactionalMapper.insertTurnover(turnover);
    }

}
