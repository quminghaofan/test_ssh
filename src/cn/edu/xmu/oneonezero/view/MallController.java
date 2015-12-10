package cn.edu.xmu.oneonezero.view;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

@Controller
@RequestMapping("/mall")
public class MallController {
	@RequestMapping("/enterMall")
	public String enterMall(HttpServletRequest request){
		
		return "store";
	}
	
	@RequestMapping("/settle")
	public String settle(HttpServletRequest request,HttpServletResponse response){
		List<CommodityArtwork> commodityArtworks=CommonMethod.jsonToFinishedItem(request);
		CommonMethod.cleanCookie(request, response);
		Double total=0.0;
		for(CommodityArtwork commodityArtwork:commodityArtworks){
			total+=commodityArtwork.getPrice();
		}
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("username",user.getName());
		request.setAttribute("total", total);
		return "checkorder";
	}
}
