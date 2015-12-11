package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping(value="/add2Cart",method = RequestMethod.GET)
	public void add2Cart(String backUrl,long itemId,String name,String type,String price,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		CommodityArtwork commodityArtwork=new CommodityArtwork();
		System.out.println(itemId);
		commodityArtwork.setId(itemId);
		commodityArtwork.setName(name);
		commodityArtwork.setType(type);
		commodityArtwork.setPrice(Double.parseDouble(price));
		String commodityArtworkJson = JSONObject.fromObject(commodityArtwork).toString();
		Cookie cookie=new Cookie(Long.toString(itemId), commodityArtworkJson);
		cookie.setMaxAge(60*60*24*7);//保留7天
		response.addCookie(cookie);
		response.sendRedirect(backUrl);//返回到原来的页面，而不是系统配置的首页，更友好
	}
	
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request) {
		request.setAttribute("commodityArtworkList", CommonMethod.jsonToFinishedItem(request));
		return "cart";
	}
	
	@RequestMapping("/delCart")
	public String delCart(long itemId,HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(Long.toString(itemId))){
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "redirect:/cart/showCart";
	}
	
	@RequestMapping("/cleanCart")
	public String cleanCart(HttpServletRequest request,HttpServletResponse response) {
		CommonMethod.cleanCookie(request, response);
		return "redirect:/cart/showCart";
	}

}
