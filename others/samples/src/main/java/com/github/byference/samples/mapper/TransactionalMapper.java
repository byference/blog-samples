package com.github.byference.samples.mapper;


import com.github.byference.samples.entity.Account;
import com.github.byference.samples.entity.Turnover;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * Transactional {@link org.apache.ibatis.annotations.Mapper}
 *
 * @author byference
 * @since 2019/05/11
 */
public interface TransactionalMapper {


    /**
     * 转出
     * @param account 用户实体{@link Account}
     * @return 更新记录条数
     */
    @Update("update account t set t.account = t.account - #{account} where t.user_name = #{userName}")
    int transferor(Account account);


    /**
     * 转入
     * @param account 用户实体{@link Account}
     * @return 更新记录条数
     */
    @Update("update account t set t.account = t.account + #{account} where t.user_name = #{userName}")
    int transferee(Account account);


    /**
     * 记录流水
     * @param turnover 流水实体{@link Turnover}
     * @return 更新记录条数
     */
    @Insert("insert into turnover VALUES (null, #{transferor}, #{transferee}, #{amount}, #{date})")
    int insertTurnover(Turnover turnover);
}
