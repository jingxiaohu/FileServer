package com.jxh.mvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

@Controller
public class ErrorHandleController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping
    public String errorHandle(HttpServletResponse response) {
    	response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String data = " test is error";
			response.getWriter().write(data);
		} catch (Exception e) {
		}
        return null;
    }
}
