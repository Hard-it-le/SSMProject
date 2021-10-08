package com.yjl.mvc.converter;

import com.yjl.mvc.entity.Address;
import org.springframework.core.convert.converter.Converter;

public class AddressConverter implements Converter<String, Address> {
    @Override
    public Address convert(String source) {

        // 1.按照约定的规则拆分源字符串
        String[] split = source.split(",");

        String province = split[0];
        String city = split[1];
        String street = split[2];

        // 2.根据拆分结果创建 Address 对象
        Address address = new Address(province, city, street);

        // 3.返回转换得到的对象
        return address;
    }
}
