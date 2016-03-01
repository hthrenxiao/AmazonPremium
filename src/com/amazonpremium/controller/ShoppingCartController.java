package com.amazonpremium.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amazonpremium.service.ManageShoppingCart;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	ManageShoppingCart shoppingCart;

 

}
