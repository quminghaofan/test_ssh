package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;

public class CommonMethod {
	/**
	 * 从cookie中获取json，转换成CommodityArtwork类型
	 * @param request
	 * @return
	 */
	public static List<CommodityArtwork> jsonToFinishedItem(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		System.out.println("cookies.length:"+cookies.length);
		int count=0;
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)return null;
		List<CommodityArtwork> commodityArtworks=new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork;
		JSONObject jsonCart;
		for (Cookie cookie : cookies) {
			if (cookie.getValue().startsWith("{")&&cookie.getName().startsWith(user.getName())) {
				jsonCart = JSONObject.fromObject(cookie.getValue());
				commodityArtwork = (CommodityArtwork) JSONObject.toBean(
						jsonCart, CommodityArtwork.class);
				commodityArtworks.add(commodityArtwork);
				count++;
			}
		}
//		System.out.println("count:"+count);
//		request.setAttribute("total", count);
//		System.out.println("commodityArtworks.size:"+commodityArtworks.size());
		return commodityArtworks;
	}
	/**
	 * 清除cookie
	 * @param request
	 * @param response
	 */
	public static void cleanCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)return;
		for (Cookie cookie : cookies) {
			if (cookie.getValue().startsWith("{")&&cookie.getName().startsWith(user.getName())) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
}
