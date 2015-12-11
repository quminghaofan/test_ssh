package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.ItemType;
import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.NewsService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/init")
public class InitController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="newsService")
	private NewsService newsService;
	
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(HttpServletRequest request){
		//获取今天要发布的4条新闻资讯
		List<News> news=newsService.getExaminedNews();
		request.setAttribute("RRlist", news);
		List<CommodityArtwork> commodityArtworks=commodityArtworkService.commodityArtworksToDisplay();
		request.setAttribute("commodityArtworkList",commodityArtworks);
		request.setAttribute("backUrl", request.getRequestURI());
		return "index";
	}
	@RequestMapping(value="/goToLogin")
	public String goToLogin(String backUrl,HttpServletRequest request){
		request.setAttribute("backUrl", backUrl);
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(String backUrl,HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		String userName=request.getParameter("username");
		String psw=request.getParameter("psw");
		User user=userService.getUserByUserNameAndPassword(userName, psw);
		if(user!=null){
			user.setName(userName);
			user.setPassword(psw);
			request.getSession().setAttribute("user",user);
			System.out.println(backUrl);
//			if(backUrl==null){
//				return "editor_index";
//			}
//			response.sendRedirect(backUrl);
			return "redirect:/init/home";
		}
		else {
			request.setAttribute("result", "fail");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public void logout(String backUrl,HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		HttpSession session=request.getSession();
		if(session!=null){
			session.removeAttribute("user");
		}
		CommonMethod.cleanCookie(request, response);
		response.sendRedirect(backUrl);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request){
		String userNameString=request.getParameter("username");
		String psw=request.getParameter("password");
		User user=new User();
		user.setName(userNameString);
		user.setPassword(psw);
		userService.insertUser(user);
		return "login";
	}
}
