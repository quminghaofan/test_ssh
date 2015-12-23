package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.ArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/admin_user")
public class AdminUserController {

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="dataDictionaryService")
	private DataDictionaryService dataDictionaryService;
	
	@Resource(name="commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;

	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllCommonUsersAndArtist());
		return "admin_userlist";
	}
	
	@RequestMapping(value="/getAllOrder")
	public String getAllOrder(HttpServletRequest request){
//		request.setAttribute("ORDERLIST", userService.get);
		return "admin_orderlist";
	}
	
	@RequestMapping("/getAllPreparatoryArtist")
	public String getAllPreparatoryArtist(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllPreparativeArtist());
		return "admin_artistapply";
	}
	
	@RequestMapping(value="/getUser")
	public String getUser(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getUserByUserName(request.getParameter("search")));
		return "admin_userlist";
	}
	@RequestMapping(value="/getOrder")
	public String getOrder(HttpServletRequest request){
		CommodityArtworkOrder commodityArtworkOrder;
		String typeString=request.getParameter("search");
		request.setAttribute("ORDERLIST", commodityArtworkOrderService.getAllCommodityArtworkOrders());
		return "admin_orderlist";
	}
	
	@RequestMapping("/getAllCommodityArtwork")
	public String getAllCommodityArtwork(HttpServletRequest request){
		request.setAttribute("ITEMLIST",commodityArtworkService.getAllCommodityArtworks());
		return "admin_commodityitem";
	}
	
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有订单
		request.setAttribute("ORDERLIST",commodityArtworkOrderService.getCommodityArtworkOrdersByUserId(user.getId()));
		return "admin_orderlist";
	}
	
	@RequestMapping("/delUser")
	public String delUser(Long userId,HttpServletRequest request){
		userService.setUserStateFalse(userId);
		return "redirect:/admin_user/getAllUser";
	}
	
	@RequestMapping("/startUsing")
	public String startUsing(Long userId,HttpServletRequest request){
		userService.setUserStateTrue(userId);
		return "redirect:/admin_user/getAllUser";
	}
	
	@RequestMapping("/exmineArtist")
	public String exmineArtist(Long userId,String type,HttpServletRequest request){
		User user=userService.getUser(userId);
		DataDictionary dataDictionary;
		if(type.equals("1")){
			dataDictionary=dataDictionaryService.getDataDictionaryByName("艺术家");
		}
		else {
			dataDictionary=dataDictionaryService.getDataDictionaryByName("普通用户");
			//TODO 不通过的原因
		}
		user.setRole(dataDictionary);
		userService.updateUser(user);
		return "redirect:/admin_user/getAllPreparatoryArtist";
	}
}