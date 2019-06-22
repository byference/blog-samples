package com.github.byference.samples.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Mybatis {@link Intercepts}.
 *
 * @author byference
 * @since 2019-06-22
 */
@Slf4j
@Component
@Intercepts(
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class })
)
public class ParameterInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        /// to be update...
        // log.info("==>  Preparing: {}", boundSql.getSql());
        // log.info("==> Parameters: {}", "");
        // log.info("<==    Updates: {}", "");
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }


    @Override
    public void setProperties(Properties properties) {

        log.info("Mybatis.databaseType: {}", properties.getProperty("databaseType"));
    }

}
