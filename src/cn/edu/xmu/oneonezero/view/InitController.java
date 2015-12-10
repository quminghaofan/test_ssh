package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.ItemType;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.NewsService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/init")
public class InitController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="newsService")
	private NewsService newsService;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(HttpServletRequest request){
		//获取今天要发布的4条新闻资讯
		request.setAttribute("RRlist", newsService.getNews(1));
		return "index";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request){//TODO 获取
		User user=new User();
		user.setId(1);//TODO
		String userName=request.getParameter("username");
		String psw=request.getParameter("psw");
		boolean isSuccess=userService.isLoginSuccessful(userName, psw);
		if(isSuccess){
			user.setName(userName);
			user.setPassword(psw);
			request.getSession().setAttribute("user",user);
			//return "editor_index";//TODO 根据角色进入不同的界面
			return "index";
		}
		else {
			request.setAttribute("result", isSuccess);
			return "login";
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request){
		String userNameString=request.getParameter("username");
		String psw=request.getParameter("password");
		return "login";
	}
	
	@RequestMapping("/add2Cart")
	public void add2Cart(long itemId,String name,String type,String price,HttpServletResponse response,HttpServletRequest request){
		ItemType itemType=new ItemType();
//		itemType.setId(itemId);
//		itemType.setName(name);
//		itemType.setType(type);
//		itemType.setPrice(price);
		String itemTypeJson = JSONObject.fromObject(itemType).toString();
		Cookie cookie=new Cookie(Long.toString(itemId), itemTypeJson);
		cookie.setMaxAge(60*60*24*7);//保留7天
		response.addCookie(cookie);
	}
	
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		List<ItemType> itemTypes=new ArrayList<ItemType>();
		ItemType itemType;
		JSONObject jsonCart;
		for(Cookie cookie:cookies){
			jsonCart = JSONObject.fromObject(cookie.getValue());
			itemType=(ItemType)JSONObject.toBean(jsonCart,ItemType.class); 
			itemTypes.add(itemType);
		}
		request.setAttribute("", itemTypes);
		return "cart";
	}
	
	public String delCart(long itemId,HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(Long.toString(itemId))){
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "redirect:/init/showCart";
	}

}
