package com.mymovie.controller;

import com.alibaba.fastjson.JSONObject;
import com.mymovie.entity.User;
import com.mymovie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(@RequestParam("user_name") String userName,
                            @RequestParam("user_pwd")String userPwd,
                            HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        User loginUser = userServices.login(userName, userPwd);
        if (loginUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
            jsonObject.put("msg", "success");
            jsonObject.put("data", loginUser);
        }else {
            jsonObject.put("msg", "fail");
        }
        return jsonObject;
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        // 1、判断用户名是否存在
        List<User> userByName = userServices.findUserByName(user.getUserName());
        if (userByName !=null && userByName.size()>0){
            // 用户名已经存在
            return "exists";
        }else {
            // 正常注册
            Integer row = userServices.register(user);
            if (row >0){
                return "success";
            }
        }
        return "fail";
    }
}
