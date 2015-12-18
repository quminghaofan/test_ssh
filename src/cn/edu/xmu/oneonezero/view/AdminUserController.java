package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/admin_user")
public class AdminUserController {

	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
//		request.setAttribute("USERLIST", userService.getAllUser());
		return "admin_userlist";
	}
	
	@RequestMapping(value="/getUser")
	public String getUser(HttpServletRequest request){
		String typeString=request.getParameter("");
		if(typeString.equals("用户名")){
			request.setAttribute("USERLIST", userService.getUserByUserName(request.getParameter("search")));
		}
		else {
			request.setAttribute("USERLIST", userService.getUsersByRole(request.getParameter("search")));
		}
		return "admin_userlist";
	}
	
	@RequestMapping(value="/getAllOrder")
	public String getAllOrder(HttpServletRequest request){
//		request.setAttribute("ORDERLIST", arg1);
		return "admin_orderlist";
	}
	@RequestMapping(value="/getOrder")
	public String getOrder(HttpServletRequest request){
		CommodityArtworkOrder commodityArtworkOrder;
		String typeString=request.getParameter("search");
//		request.setAttribute("ORDERLIST", arg1);
		return "admin_orderlist";
	}
	
	@RequestMapping("/getAllCommodityArtwork")
	public String getAllCommodityArtwork(HttpServletRequest request){
//		request.setAttribute("", arg1);
		return "";
	}

//	@Qualifier("")
//	private 
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有订单
//		request.setAttribute("ORDERLIST", arg1);
		return "admin_orderlist";
	}
}