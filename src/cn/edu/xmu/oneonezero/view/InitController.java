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

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		List<News> news = newsService.getExaminedNews();
		request.setAttribute("RRlist", news);
		List<CommodityArtwork> commodityArtworks = commodityArtworkService
				.commodityArtworksToDisplay();
		request.setAttribute("commodityArtworkList", commodityArtworks);
		return "index";
	}

	@RequestMapping(value = "/goToLogin", method = RequestMethod.GET)
	public String goToLogin(String backUrl, HttpServletRequest request) {
		request.getSession().setAttribute("backUrl", backUrl);
		return "login";
	}

	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String backUrl = (String) request.getSession().getAttribute("backUrl");
		String userName = request.getParameter("username");
		String psw = request.getParameter("psw");
		User user = userService.getUserByUserNameAndPassword(userName, psw);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			System.out.println("backurl:"+backUrl);
			if (backUrl == null) {
				backUrl = "/test_ssh/jsp/editor_index.jsp";
			} else {
				backUrl = backUrl.replaceAll("'", "");
			}
		} else {
//			request.setAttribute("result", "fail");
			backUrl = "/test_ssh/jsp/login.jsp?result=fail";
		}
		response.sendRedirect(backUrl);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(String backUrl, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CommonMethod.cleanCookie(request, response);
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("user");
		}
		response.sendRedirect(backUrl);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request) {
		String userNameString = request.getParameter("username");
		String psw = request.getParameter("password");
		User user = new User();
		user.setName(userNameString);
		user.setPassword(psw);
		userService.insertUser(user);
		System.out.println("login");
		return "login";
	}
}
