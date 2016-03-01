package com.amazonpremium.controller;

import java.math.BigDecimal;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.amazonpremium.model.User;

import com.amazonpremium.service.ManageUser;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	ManageUser users;
	
	@RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp){      
		String username  = req.getParameter("name");
		String password  =req.getParameter("password");		
		if(users.login(username, password)){
			//We will change success page in the next few days and the same for error page.
			return "success";
		}
        return "error";
    }
	
	@RequestMapping("/regist")
    public String regist(HttpServletRequest req, HttpServletResponse resp){      
		
		String username  = req.getParameter("name");
		String password  =req.getParameter("password");
		Date birthday = new Date(req.getParameter("birthday"));
		Date rdate = new Date(req.getParameter("rate"));
		BigDecimal balance = new BigDecimal(req.getParameter("balance"));
	    User user = new User(username, password, birthday, rdate, balance);
	    
	    
		if(users.registration(user)){
			return "success";
		}
        return "error";
    }

 
}
