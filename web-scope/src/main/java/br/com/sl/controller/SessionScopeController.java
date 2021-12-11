package br.com.sl.controller;

import br.com.sl.model.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SessionScopeController {

    @Autowired
    MyBean myBean;

    @RequestMapping("/test1")
    public void test1(HttpServletResponse response) throws IOException {
        response.getWriter().write("Old website name:= " + myBean.getWebsiteName() + "<br>");
        myBean.setWebsiteName("Name Updated !!!");
        response.getWriter().write("update website name for:= " + myBean.getWebsiteName() + "<br>");
    }

    @RequestMapping("/test2")
    public void test2(HttpServletResponse response) throws IOException {
        response.getWriter().write("the website name := " + myBean.getWebsiteName() + "<br>");
    }
}