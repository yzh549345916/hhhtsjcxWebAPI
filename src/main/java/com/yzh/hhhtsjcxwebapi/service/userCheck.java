package com.yzh.hhhtsjcxwebapi.service;

import com.yzh.hhhtsjcxwebapi.Result.LoginResult;
import com.yzh.hhhtsjcxwebapi.dao.sqlserverSjcxDao;
import com.yzh.hhhtsjcxwebapi.model.userModel;
import com.yzh.hhhtsjcxwebapi.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
public class userCheck {
    public static LoginResult userCheck(String userID, String userPassword, HttpServletRequest httpServletRequest) {
        SqlSessionFactory sqlSessionFactorysjcx = SqlSessionFactoryUtil.getSqlserverSjcxSessionFactory();
        SqlSession sessionSjcx = sqlSessionFactorysjcx.openSession(true);
        sqlserverSjcxDao mySjcx = sessionSjcx.getMapper(sqlserverSjcxDao.class);
        List<userModel> users = new ArrayList<>();
        try {
            users = mySjcx.getUser(userID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users.size() > 0) {
            userModel myUser = users.get(0);
            if (myUser.getUserPassWord().equals(userPassword)) {
                switch (myUser.getUserLevel()) {
                    case -999:
                        return new LoginResult(200, "150100");
                    case -2:
                        return new LoginResult(-2, "150100");
                    case -3:
                        return new LoginResult(-3, "150100");
                    case 1:
                        if(myUser.getExpirationTime().compareTo(new Date())<0){
                            mySjcx.updateLevel(myUser.getUserID(),-2);
                            return new LoginResult(-2, myUser.getAdmin_Code());
                        }
                        String myIP = getIP(httpServletRequest);
                        if (checkIP(myIP, myUser.getUserIP())) {
                            return new LoginResult(200, myUser.getAdmin_Code());
                        }else {
                            return new LoginResult(204, myUser.getAdmin_Code());
                        }
                    case 999:
                        return new LoginResult(200, myUser.getAdmin_Code());
                    case -1:
                        return new LoginResult(-1, "150100");
                    default:
                        return new LoginResult(202, "150100");
                }

            } else {
                return new LoginResult(201);
            }

        } else {
            return new LoginResult(202);
        }

        // 对 html 标签进行转义，防止 XSS 攻击

    }

    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if("0:0:0:0:0:0:0:1".equals(ip)){
            ip="127.0.0.1";
        }
        return ip;
    }

    private static boolean checkIP(String myip, String checkIPs) {
        try {
            checkIPs = checkIPs.replace("，", ",");
            for (String checkIP : checkIPs.split(",")
            ) {
                String[] checkSz = checkIP.split("\\.");
                String[] myipSz = myip.split("\\.");
                if (checkSz.length == myipSz.length) {
                    for (int i = 0; i < checkSz.length; i++) {
                        if (checkSz[i].equals("*")) {
                            return true;
                        } else {
                            if (checkSz[i].equals(myipSz[i])) {
                                if (i == checkSz.length - 1) {
                                    return true;
                                } else {
                                    continue;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
}
