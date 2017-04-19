package com.springmvc.mysql.dialect;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by randy on 17-4-15.
 *
 *  e : 处理hibernate 自动建表的时候, 编码不是utf-8.
 *
 **/
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
