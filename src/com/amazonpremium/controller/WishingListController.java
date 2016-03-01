package com.amazonpremium.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazonpremium.service.ManageWishingList;

@Controller
@RequestMapping("/wishinglist")
public class WishingListController {

	@Autowired
	ManageWishingList wishingList;
	
	@RequestMapping(value = "/listall/{username}", method = RequestMethod.GET)
	public ModelAndView getWishingList(@PathVariable(value="username") String username) {
		ArrayList list = wishingList.getWishingList(username);
		ModelAndView mv = new ModelAndView();
		mv.addObject("listCategories", list);
		mv.setViewName("users");
		return mv;
	}
	
	// Similar Restful
	@RequestMapping(value = "/addgood/{username}/good/{id}", method = RequestMethod.GET)
	public ModelAndView addGood(@PathVariable(value="username") String username,
			@PathVariable(value="id") int id) {
 
		wishingList.addGood(username, id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		return mv;
	}
	
	
	@RequestMapping(value = "/dumplist", method = RequestMethod.GET)
	public ModelAndView dumpList(@PathVariable(value="username") String username){
		wishingList.dumpList(username);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		return mv;
	}
	
	
	@RequestMapping(value = "/deletegood/{username}/good/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGood(@PathVariable(value="username") String username,@PathVariable(value="id") int id){
		wishingList.deleteGood(username, id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		return mv;
	}
}
