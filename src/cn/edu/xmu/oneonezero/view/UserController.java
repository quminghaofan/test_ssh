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
@RequestMapping("/admin_user")
public class UserController {

	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllUser());
		return "admin_userlist";
	}
	
	@RequestMapping(value="/getUser")
	public String getUser(HttpServletRequest request){
		String typeString=request.getParameter("");
		if(typeString.equals("用户名")){
			request.setAttribute("USERLIST", userService.getUserByName(request.getParameter("search")));
		}
		else {
			request.setAttribute("USERLIST", userService.getUserByRole(request.getParameter("search")));
		}
		return "admin_userlist";
	}
	
//	@RequestMapping("/getUser")
//	public String getUser(long id,HttpServletRequest request){
//		
//		request.setAttribute("user", userService.getUser(id));
//	
//		return "/editUser";
//	}
//	
//	@RequestMapping("/toAddUser")
//	public String toAddUser(){
//		return "/addUser";
//	}
//	
//	@RequestMapping("/addUser")
//	public String addUser(User user,HttpServletRequest request){
//		
//		userService.insertUser(user);
//		
//		return "redirect:/user/getAllUser";
//	}
//	
//	@RequestMapping("/delUser")
//	public void delUser(long id,HttpServletResponse response){
//		
//		String result = "{\"result\":\"error\"}";
//		
//		if(userService.delUser(id)){
//			result = "{\"result\":\"success\"}";
//		}
//		
//		response.setContentType("application/json");
//		
//		try {
//			PrintWriter out = response.getWriter();
//			out.write(result);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping("/updateUser")
//	public String updateUser(User user,HttpServletRequest request){
//		
//		if(userService.updateUser(user)){
//			user = userService.getUser(user.getId());
//			request.setAttribute("user", user);
//			return "redirect:/user/getAllUser";
//		}else{
//			return "/error";
//		}
//	}
}