package cn.edu.xmu.oneonezero.view;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@RequestMapping(value="/add2Cart",method = RequestMethod.GET)
	public void add2Cart(String backUrl,long itemId,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
<<<<<<< Updated upstream
		String commodityArtworkJson = commodityArtworkService.getCommodityArtworkWithJSONTypeById(itemId).toString();
//		System.out.println("commodityArtworkJson:"+commodityArtworkJson);
=======
		CommodityArtwork commodityArtwork=new CommodityArtwork();//TODO 返回json类型
//		System.out.println(itemId);
		commodityArtwork.setId(itemId);
		commodityArtwork.setName(name);
		commodityArtwork.setType(type);
		commodityArtwork.setPrice(Double.parseDouble(price));
<<<<<<< Updated upstream
		String commodityArtworkJson = JSONObject.fromObject(commodityArtwork).toString();
>>>>>>> Stashed changes
		User user=(User)request.getSession().getAttribute("user");
		Cookie cookie=new Cookie(user.getName()+"#"+Long.toString(itemId), commodityArtworkJson);
		cookie.setPath(request.getContextPath());
		System.out.println("add-path:"+cookie.getPath());
		cookie.setMaxAge(60*60*24*7);//保留7天 
		response.addCookie(cookie);
		response.sendRedirect(backUrl);//返回到原来的页面，更友好
=======
//		String commodityArtworkJson = JSONObject.fromObject(commodityArtwork).toString();
//		Cookie cookie=new Cookie(Long.toString(itemId), commodityArtworkJson);
//		cookie.setMaxAge(60*60*24*7);//保留7天
//		response.addCookie(cookie);
//		response.sendRedirect(backUrl);//返回到原来的页面，而不是系统配置的首页，更友好
>>>>>>> Stashed changes
	}
	
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request) {
//		List<CommodityArtwork> commodityArtworks=CommonMethod.jsonToFinishedItem(request);
//		System.out.println("name:"+commodityArtworks.get(0).getName());
		request.setAttribute("commodityArtworkList", CommonMethod.jsonToFinishedItem(request));
		return "cart";
	}
	
	@RequestMapping("/delCart")
	public String delCart(long itemId,HttpServletRequest request,HttpServletResponse response){
		User user=(User)request.getSession().getAttribute("user");
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(user.getName()+"#"+Long.toString(itemId))
					/*&&cookie.getPath()!=null
					&&cookie.getPath().equals(request.getContextPath())*/){
				Cookie newcookie=new Cookie(cookie.getName(), null);
				newcookie.setPath(request.getContextPath()); 
				System.out.println("del-request:"+request.getContextPath());
				System.out.println("del:"+cookie.getPath());
				newcookie.setMaxAge(0);
				response.addCookie(newcookie);
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
