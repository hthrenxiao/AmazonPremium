package com.amazonpremium.controller;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	
    //Service from service layer
    @Resource(name="factory")
    private SessionFactory session;
    
    @RequestMapping(value="/manager",method=RequestMethod.GET)
    public ModelAndView hello2(){
    	System.out.println(session.getClass());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "HelloMVC");
        mv.setViewName("users");
        return mv;
    }
    
    @RequestMapping(value="/count",method=RequestMethod.GET)
    public ModelAndView count(){  
     //   int c = service.userCount();
        ModelAndView mv = new ModelAndView();
       // mv.addObject("message", c);
        mv.setViewName("users");
        return mv;
    }
}