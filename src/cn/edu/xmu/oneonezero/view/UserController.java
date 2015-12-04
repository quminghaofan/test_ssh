package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name="userManager")
	private UserService userManager;

	
	@RequestMapping("/getUser")
	public String getUser(long id,HttpServletRequest request){
		
		request.setAttribute("user", userManager.getUser(id));
	
		return "/editUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(){
		return "/addUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		
		userManager.insertUser(user);
		
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/delUser")
	public void delUser(long id,HttpServletResponse response){
		
		String result = "{\"result\":\"error\"}";
		
		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		
		response.setContentType("application/json");
		
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user,HttpServletRequest request){
		
		if(userManager.updateUser(user)){
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "redirect:/user/getAllUser";
		}else{
			return "/error";
		}
	}
}