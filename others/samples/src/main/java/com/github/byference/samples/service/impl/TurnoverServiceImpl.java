package com.github.byference.samples.service.impl;

import com.github.byference.samples.entity.Turnover;
import com.github.byference.samples.mapper.TransactionalMapper;
import com.github.byference.samples.service.TurnoverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * default {@link TurnoverService} implementation
 *
 * @author byference
 * @since 2019/05/12
 */
@Service
@AllArgsConstructor
public class TurnoverServiceImpl implements TurnoverService {

    private final TransactionalMapper transactionalMapper;


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public int insertTurnover(Turnover turnover) {
        // 记录流水
        turnover.setDate(new Date());
        return transactionalMapper.insertTurnover(turnover);
    }
}
