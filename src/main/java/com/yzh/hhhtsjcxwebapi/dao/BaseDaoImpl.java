package com.yzh.hhhtsjcxwebapi.dao;

import com.yzh.hhhtsjcxwebapi.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BaseDaoImpl implements BaseDao {


    public SqlSession getSqlserverSjcxSessionFactory() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlserverSjcxSessionFactory();
        //自动提交事务
        sqlSessionFactory.openSession(true);
        return sqlSessionFactory.openSession();
    }

}
