/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mathan.starwarsproject;

/**
 *
 * @author HP
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerClass {

    @RequestMapping("StarwarsProject/")
    public ModelAndView defaultPage() {
        return new ModelAndView("index.html");
    }

    @RequestMapping("/StarwarsProject/index.html")
    public ModelAndView defaultPageAgain() {
        return new ModelAndView("index.html");
    }

    @RequestMapping("/findThePhrase")
    public ModelAndView login(HttpServletResponse responses, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        responses.setContentType("text/html");
        responses.setCharacterEncoding("UTF-8");
        modelAndView.setViewName("login.jsp");
        return modelAndView;
    }
}
