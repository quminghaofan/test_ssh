package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONObject;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;

/**
 * 购物车
 * @author DELL
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name = "commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;

	/**
	 * 添加到购物车
	 * @param itemId 艺术品id
	 * @param response 应答
	 * @param request 请求
	 * @throws IOException 读入异常
	 */
	@RequestMapping(value = "/add2Cart")
	@ResponseBody
	public void add2Cart(String itemId,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		if (itemId != null) {
			String commodityArtworkJson = commodityArtworkService
					.getCommodityArtworkWithJSONTypeById(Long.parseLong(itemId))
					.toString();
			CommonMethod.addCookie(Long.parseLong(itemId),
					commodityArtworkJson, request, response);
		}
	}

	/**
	 * 进入购物车
	 * @param request 请求
	 * @return String
	 * @throws UnsupportedEncodingException 编码异常
	 */
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setAttribute("commodityArtworkList",
				CommonMethod.jsonToCommodityArtwork(request));
		return "cart";
	}

	/**
	 * 删除购物车里的商品
	 * @param itemId 艺术品id
	 * @param request 请求
	 * @param response 应答
	 * @return String
	 */
	@RequestMapping("/delCart")
	public String delCart(long itemId, HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(
					user.getName() + "#" + Long.toString(itemId))) {
				Cookie newcookie = new Cookie(cookie.getName(), null);
				newcookie.setPath(request.getContextPath());
				// System.out.println("del-request:"+request.getContextPath());
				// System.out.println("del:"+cookie.getPath());
				newcookie.setMaxAge(0);
				response.addCookie(newcookie);
			}
		}
		return "redirect:/cart/showCart";
	}

	/**
	 * 清空购物车
	 * @param request 请求
	 * @param response 应答
	 * @return String
	 */
	@RequestMapping("/cleanCart")
	public String cleanCart(HttpServletRequest request,
			HttpServletResponse response) {
		CommonMethod.cleanCookie(request, response);
		return "redirect:/cart/showCart";
	}

}
