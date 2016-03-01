package com.amazonpremium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazonpremium.service.ManageGoods;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	
	@Autowired
	ManageGoods goods;

	@RequestMapping(value = "/listallgoods/listall", method = RequestMethod.GET)
	public ModelAndView listAllGoods() {
        List list = goods.listAllGoods();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", list);
		mv.setViewName("users");
		return mv;
	}
	
	
}
