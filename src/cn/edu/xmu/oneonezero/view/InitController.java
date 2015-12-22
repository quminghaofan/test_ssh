package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.NewsService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/init")
public class InitController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "newsService")
	private NewsService newsService;

	@Resource(name = "commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@Resource(name = "dataDictionaryService")
	private DataDictionaryService dataDictionaryService;

	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request) {
		List<News> news = newsService.getExaminedNews();
		request.setAttribute("RRlist", news);
		List<CommodityArtwork> commodityArtworks = commodityArtworkService.commodityArtworksToDisplay();
		request.setAttribute("commodityArtworkList", commodityArtworks);
		return "index";
	}

	@RequestMapping(value = "/goToLogin", method = RequestMethod.GET)
	public String goToLogin(String backUrl, HttpServletRequest request) {
		request.getSession().setAttribute("backUrl", backUrl);
		return "login";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String backUrl = (String) request.getSession().getAttribute("backUrl");
		String userName = request.getParameter("username");
		String psw = request.getParameter("psw");
		User user = userService.getUserByUserNameAndPassword(userName, psw);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			System.out.println("backurl1:"+backUrl);
			if (backUrl == null) {
				String roleName=user.getRole().getName();
				if(roleName.equals("超级管理员"))return "super_index";
				else if(roleName.equals("普通管理员"))return "admin_index";
				else if(roleName.equals("主编"))return "chiefEditor_index";
				else if(roleName.equals("采编"))return "editor_index";
				else {
					request.setAttribute("result", "fail");
					return "login";
				}
			} else {
				backUrl = backUrl.replaceAll("'", "");
				System.out.println("backur2:"+backUrl);
			}
		} else {
			request.setAttribute("result", "fail");
			return "login";
		}
		response.sendRedirect(backUrl);
		return null;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(String backUrl, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CommonMethod.cleanCookie(request, response);
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("user");
		}
		if(backUrl==null){
			backUrl="goToLogin";
		}
		response.sendRedirect(backUrl);
	}

	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request) {
		String userNameString = request.getParameter("username");
		String psw = request.getParameter("password");
		User user = new User();
		user.setName(userNameString);
		user.setPassword(psw);
		user.setRole(dataDictionaryService.getDataDictionaryByName("预备艺术家"));
		userService.insertUser(user);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value="/judgeUserName")
	public String judgeUserName(String username){
		if(!userService.isNameExist(username)){
			return "success";
		}
		return "error";
	}
}
