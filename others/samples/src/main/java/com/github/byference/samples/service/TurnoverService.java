package com.github.byference.samples.service;

import com.github.byference.samples.entity.Turnover;

/**
 * Turnover {@link org.springframework.stereotype.Service}
 *
 * @author byference
 * @since 2019/05/12
 */
public interface TurnoverService {

    /**
     * 记录流水
     * @param turnover 流水实体{@link Turnover}
     * @return 更新记录条数
     */
    int insertTurnover(Turnover turnover);
}
