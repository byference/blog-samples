package com.github.byference.samples.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * Mybatis Plugin Example
 *
 * @author byference
 * @since 2019-07-21
 */
@Slf4j
@Component
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class})})
public class ExamplePlugin implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        log.info("==> bound sql: {}", boundSql.getSql());
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }


    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        log.info("==> {}", dialect);
    }

}
