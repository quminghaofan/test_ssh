package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.service.NewsService;

public class CommonMethod {
	/**
	 * 从cookie中获取json，转换成FinishedItem类型
	 * @param request
	 * @return
	 */
	public static List<CommodityArtwork> jsonToFinishedItem(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		List<CommodityArtwork> finishedItems=new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork;
		JSONObject jsonCart;
		for(Cookie cookie:cookies){
			jsonCart = JSONObject.fromObject(cookie.getValue());
			commodityArtwork=(CommodityArtwork)JSONObject.toBean(jsonCart,CommodityArtwork.class); 
			finishedItems.add(commodityArtwork);
		}
		return finishedItems;
	}
	/**
	 * 清除cookie
	 * @param request
	 * @param response
	 */
	public static void cleanCookie(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setValue(null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
