package com.yzh.hhhtsjcxwebapi.Controller;

import com.yzh.hhhtsjcxwebapi.Pojo.User;
import com.yzh.hhhtsjcxwebapi.Result.LoginResult;
import com.yzh.hhhtsjcxwebapi.dao.sqlserverSjcxDao;
import com.yzh.hhhtsjcxwebapi.model.userModel;
import com.yzh.hhhtsjcxwebapi.service.userCheck;
import com.yzh.hhhtsjcxwebapi.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LoginController {

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "api/login")
    public LoginResult login(@RequestBody User requestUser, HttpServletRequest request) {
        return userCheck.userCheck( HtmlUtils.htmlEscape(requestUser.getUsername()), HtmlUtils.htmlEscape(requestUser.getPassword()),request);
    }
}
