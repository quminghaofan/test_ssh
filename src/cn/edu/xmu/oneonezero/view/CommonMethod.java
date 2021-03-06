package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;

/**
 * 公共方法
 * @author DELL
 *
 */
public class CommonMethod {
	/**
	 * 从cookie中获取json，转换成CommodityArtwork类型
	 * @param request 请求
	 * @return String
	 * @throws UnsupportedEncodingException  编码异常
	 */
	public static List<CommodityArtwork> jsonToCommodityArtwork(HttpServletRequest request) throws UnsupportedEncodingException{
		Cookie[] cookies=request.getCookies();
//		System.out.println("cookies.length:"+cookies.length);
		int count=0;
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)return null;
		List<CommodityArtwork> commodityArtworks=new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork;
		JSONObject jsonCart;
		for (Cookie cookie : cookies) {
//			System.out.println("show-path:"+cookie.getPath());
			if (cookie.getName().startsWith(user.getName())) {
				jsonCart = JSONObject.fromObject(URLDecoder.decode(cookie.getValue(),"utf-8"));
//				System.out.println(cookie.getValue());
				commodityArtwork = (CommodityArtwork) JSONObject.toBean(
						jsonCart, CommodityArtwork.class);
//				System.out.println("commodityArtwork.getName():"+commodityArtwork.getName());
				commodityArtworks.add(commodityArtwork);
				count++;
			}
		}
//		System.out.println("count:"+count);
		request.setAttribute("total", count);
//		System.out.println("commodityArtworks.size:"+commodityArtworks.size());
		return commodityArtworks;
	}
	/**
	 * 清除cookie
	 * @param request 请求
	 * @param response 应答
	 */
	public static void cleanCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		User user=(User)request.getSession().getAttribute("user");
		if(user==null)return;
		for (Cookie cookie : cookies) {
			if (cookie.getName().startsWith(user.getName())) {
				Cookie newcookie=new Cookie(cookie.getName(), null);
				newcookie.setPath(request.getContextPath()); 
//				System.out.println("logout-path:"+request.getContextPath());
				newcookie.setMaxAge(0);
				response.addCookie(newcookie);
			}
		}
	}
	
	/**
	 * 添加到cookie
	 * @param itemId 艺术品id
	 * @param value 值
	 * @param request 请求
	 * @param response 应答
	 * @throws UnsupportedEncodingException 编码异常
	 */
	public static void addCookie(Long itemId,String value,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
//		System.out.println("commodityArtworkJson:"+commodityArtworkJson);
		User user=(User)request.getSession().getAttribute("user");
		Cookie cookie=new Cookie(user.getName()+"#"+Long.toString(itemId), URLEncoder.encode(value,"utf-8"));
		cookie.setPath(request.getContextPath());
//		System.out.println("add-path:"+cookie.getPath());
		cookie.setMaxAge(60*60*24*7);//保留7天 
		response.addCookie(cookie);
		
	}
	
	/**
	 * 获取图片保存路径
	 * @param request 请求
	 * @return String
	 */
	public static String getPicUrl(HttpServletRequest request) {
//		System.out.println("路径："+request.getSession().getServletContext().getRealPath("/attached"));
		return request.getSession().getServletContext().getRealPath("/attached");
		
	}
}
