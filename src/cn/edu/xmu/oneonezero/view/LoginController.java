package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/editor")
public class LoginController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request){
		User user=new User();
		String userName=request.getParameter("username");
		String psw=request.getParameter("psw");
		user.setName(userName);
		user.setPassword(psw);
		request.setAttribute("user",user);
		boolean isSuccess=userService.isLoginSuccessful(userName, psw);
		if(isSuccess)
			return "editor_index";//TODO 根据角色进入不同的界面
		else {
			request.setAttribute("result", isSuccess);
			return "login";
		}
	}
}
