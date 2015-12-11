package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;

public class CommonMethod {
	/**
	 * 从cookie中获取json，转换成CommodityArtwork类型
	 * @param request
	 * @return
	 */
	public static List<CommodityArtwork> jsonToFinishedItem(HttpServletRequest request){
		Cookie[] cookies=request.getCookies();
		int count=0;
		List<CommodityArtwork> commodityArtworks=new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork;
		JSONObject jsonCart;
		System.out.println(cookies.length);
		for (Cookie cookie : cookies) {
			if (cookie.getValue().startsWith("{")) {
				jsonCart = JSONObject.fromObject(cookie.getValue());
				commodityArtwork = (CommodityArtwork) JSONObject.toBean(
						jsonCart, CommodityArtwork.class);
				commodityArtworks.add(commodityArtwork);
				count++;
			}
		}
		request.setAttribute("total", count);
		return commodityArtworks;
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
