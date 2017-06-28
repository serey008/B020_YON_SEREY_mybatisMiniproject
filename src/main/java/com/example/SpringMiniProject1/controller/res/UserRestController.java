package com.example.SpringMiniProject1.controller.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringMiniProject1.model.User;
import com.example.SpringMiniProject1.service.UserService;

@Controller
public class UserRestController {

	private UserService userService;
	

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user/dashboard")
	public String findAll(ModelMap model)
	{
		model.addAttribute("USER", userService.userList());
		return "/admin/dashboard";
	}
	@RequestMapping("/user/user-list")
	public String showUserList(ModelMap model)
	{
		model.addAttribute("USER", userService.userList());
		return "/admin/user-list";
	}
	
	@RequestMapping("/user/add")
	public String addUser(ModelMap model){	
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);	
		return "/admin/user-cu";	
	}
	@PostMapping("/user/save")
	public String userlist(@ModelAttribute User user, ModelMap model){
		
		model.addAttribute("user", userService.save(user));
		return "redirect:/user/dashboard";
	
	}
	@RequestMapping(value ="/user/remove")
	public String remove(@RequestParam String user_hash) {

		if(userService.delete(user_hash)){
			System.out.println("Success");
		}
		System.out.println(user_hash);
		return "redirect:/user/user-list";
	}
	
	@GetMapping(value ="/user/edit")
	public String edit(ModelMap model, @RequestParam("user_hash") String user_hash) {
		User user=userService.findOne(user_hash);
			
		System.out.println("findOne User Hash" + user.getUser_hash());
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		return "/admin/user-cu";
	}
	
	@PostMapping(value = "/user/update")
	public String update(@ModelAttribute("user") User user) 
	{
		System.out.println("user_hash "+user.getUser_hash());
		
		if(userService.update( user))		
			System.out.println("updated!!");
		else
		System.out.println("Cannot updated--------!");
		return "redirect:/user/user-list";
	}
	@RequestMapping(value = "/user/aid")
	public String detailpage(ModelMap model, @RequestParam("user_hash") String user_hash) {
		User user = userService.findOne(user_hash);
		model.addAttribute("user", user);
		return "/admin/user-detail";
	}
		
}
