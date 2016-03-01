package com.amazonpremium.controller;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amazonpremium.service.ManageCategory;

@Controller
@RequestMapping("/managecategory")
public class CategoryController {
		
	//Warning:Do not new object by yourself, spring framework will automatically create new any thing you want.
	//Only add @Autowired
	@Autowired
	ManageCategory category;
	
    @RequestMapping(value="/listGoodsOfCategory/{id}",method=RequestMethod.GET)
    public ModelAndView listGoodsOfCategory(@PathVariable(value="id") int id){

    	List list = category.listGoodsOfCategory(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", list);
      //  mv.addObject("bo",bo);
        mv.setViewName("users");
        return mv;
    }
    
    @RequestMapping(value="/listGoodsOfCategory/listall",method=RequestMethod.GET)
    public ModelAndView listCategories(){  
    	HashMap<Integer,String > list = category.listCategories();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listCategories", list);
      //  mv.addObject("bo",bo);
        mv.setViewName("users");
        return mv;
    }
}