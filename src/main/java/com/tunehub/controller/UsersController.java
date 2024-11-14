package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entities.Users;
import com.tunehub.services.UsersService;

@Controller
public class UsersController
{
	@Autowired
	UsersService userv;
	
	//for register and data base activity
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean userstatus = userv.emailExists(user.getEmail());
		if(userstatus == false)
		{
		userv.addUsers(user);
		System.out.println("User added successfully.");
		}else
		{
			System.out.println("User is already exists.");
		}
		return"home";
	}
	
	@PostMapping("/login")
	public String validateUsers(@RequestParam String email,
								@RequestParam String password)
	{
		//boolean loginstatus = userv.validateUser(email,password);
		
		//invoking validateUse () in service
		if(userv.validateUser(email,password) == true)
		{
			//checking weather the user is admin or customer
			if(userv.getRole(email).equals("admin"))
			{
			return "adminhome";
			}
		else
		{
			return "customerhome";
		}
		
	}
	else 
	{
		return"loginfail";
	}

}
}
