package com.dempapp.springbootDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainApp2 {
	@Autowired
	private UserService userService;
		
	@PostMapping("/login")
	public String loginValid(@RequestParam("uname")String name,@RequestParam("pass")String pass) {
		if(userService.loginValid(name, pass)) {
			
			return "login successfull";
			}
			return "login failed";
		}
		
	@PostMapping("/register")
	public String addUser(@RequestParam("uname")String name,@RequestParam("pass")String pass,@RequestParam("city")String city) {
		
		if(userService.addUser(name, pass, city)) {
			
		return "regsiter successfull";
		}
		return "register failed";
	}

	@GetMapping("/loadusers")
	public List<User> load(){
		return userService.loadUsers();
	}
	@GetMapping("/finduser/{name}")
	public String findUser(@PathVariable("name") String name) {
		if(userService.findUser(name)) {
			return "user found ";
			
		}
		return "user not found";
	}

	@GetMapping("/updateuser/{name}/{city}")
public String updateUser(@PathVariable("name") String name, @PathVariable("city") String city) {
		if(userService.updateUser(name, city)) {
			return "user updated";
			
		}
	return "sorry, user couldnt be update";
	
}
	@GetMapping("/deleteuser/{uname}")
	public String deleteUser(@PathVariable("uname") String name) {
		if(userService.deleteUser(name)) {
			return "User was deleted";
		}
	
		return "User was not deleted";
	
	}
}
	
		
