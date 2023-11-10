package com.example.democommunity.controller;


import com.example.democommunity.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public  String getata(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据
        //输出请求方式
        System.out.println(request.getMethod());
        //输出请求路径
        System.out.println(request.getServletPath());
        //输出请求消息头
        Enumeration<String> enumeration=request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=request.getHeader(name);
            System.out.println(name+" : "+value);
        }
        System.out.println(request.getParameter("code"));

        //response：对浏览器做出响应的对象   返回响应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        //底层对象做的事情
        writer.write("<h1>牛客网<h1>");
    }

    // /student？current=123
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam (name="current",required = false,defaultValue = "1") int current)
    {
        System.out.println(current);
        return "student";
    }


    //GET请求  获取数据
    // /student/123
    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }
////POST请求
//    @RequestMapping(path="/student",method = RequestMethod.POST)
//    @ResponseBody
//    public String addStudent(String name){
//        System.out.println(name);
//        return "add a student";
//    }

    //异步请求（当前网页不刷新，但是访问了服务器，返回了一个结果）向浏览器响应json数据
    //java对象  --> json字符串  -->js对象    json字符串可以转换为多种对象
    @RequestMapping(path="/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张山");
        emp.put("age",23);
        return emp;
    }

}
