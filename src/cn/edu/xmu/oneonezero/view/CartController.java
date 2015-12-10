package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping("/add2Cart")
	public void add2Cart(long itemId,String name,String type,String price,HttpServletResponse response,HttpServletRequest request){
		CommodityArtwork commodityArtwork=new CommodityArtwork();
//		commodityArtwork.setId(itemId);
//		commodityArtwork.setName(name);
//		commodityArtwork.setType(type);
//		commodityArtwork.setPrice(price);
		String commodityArtworkJson = JSONObject.fromObject(commodityArtwork).toString();
		Cookie cookie=new Cookie(Long.toString(itemId), commodityArtworkJson);
		cookie.setMaxAge(60*60*24*7);//保留7天
		response.addCookie(cookie);
	}
	
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request) {
		request.setAttribute("commodityArtworkList", CommonMethod.jsonToFinishedItem(request));
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
		return "redirect:/cart/showCart";
	}
	
	public String cleanCart(HttpServletRequest request,HttpServletResponse response) {
		CommonMethod.cleanCookie(request, response);
		return "redirect:/cart/showCart";
	}

}
