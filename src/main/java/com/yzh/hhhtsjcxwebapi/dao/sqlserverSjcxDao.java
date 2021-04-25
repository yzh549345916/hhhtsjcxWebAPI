package com.yzh.hhhtsjcxwebapi.dao;

import com.yzh.hhhtsjcxwebapi.model.userModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface sqlserverSjcxDao extends BaseDao {
    public List<userModel> getUser(@Param("userID") String userID);
    public Integer updateLevel(@Param("userID") String userID,@Param("userLevel") Integer userLevel);
}
