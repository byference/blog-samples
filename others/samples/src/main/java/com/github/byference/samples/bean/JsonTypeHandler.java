package com.github.byference.samples.bean;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JsonTypeHandler
 *
 * @author byference
 * @since 2019-07-27
 */
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {


    private Class<T> type;

    public JsonTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }


    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {

        String value = rs.getString(columnName);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, type);
    }


    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, type);
    }


    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return JSON.parseObject(value, type);
    }
}
