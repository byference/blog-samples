package com.github.byference.samples.service;

import com.github.byference.samples.entity.Turnover;

/**
 * Transactional {@link org.springframework.stereotype.Service}
 *
 * @author byference
 * @since 2019/05/11
 */
public interface TransactionalService {

    /**
     * 转账
     * @param turnover 转账行为信息
     */
    void transfer(Turnover turnover);
}
