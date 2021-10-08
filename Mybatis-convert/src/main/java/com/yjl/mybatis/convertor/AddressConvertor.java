package com.yjl.mybatis.convertor;

import com.yjl.mybatis.entity.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressConvertor extends BaseTypeHandler<Address> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Address parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Address getNullableResult(ResultSet rs, String columnName) throws SQLException {

        // 1.从结果集中获取原始字符串
        String addressOriginalString = rs.getString(columnName);

        // 2.根据预设的转换规则，将字符串转换为Address类型对象
        String[] split = addressOriginalString.split(",");

        String province = split[0];
        String city = split[1];
        String street = split[2];

        return new Address(province, city, street);
    }

    @Override
    public Address getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Address getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
