package com.yzh.hhhtsjcxwebapi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlserverSjcxSessionFactory;

    /**
     * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
     * SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
     * 而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。
     *
     * SqlSessionFactoryBuilder 最佳作用域是方法作用域（也就是局部方法变量）
     * SqlSessionFactory 最佳作用域是应用作用域
     * SqlSession 最佳的作用域是请求或方法作用域
     */
    public static SqlSessionFactory getSqlserverSjcxSessionFactory() {
        if (sqlserverSjcxSessionFactory != null) {
            return sqlserverSjcxSessionFactory;
        }
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            sqlserverSjcxSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"developmentSjcx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlserverSjcxSessionFactory;
    }
}
