package cn.edu.xmu.oneonezero.view;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.ArtworkOrderService;
import cn.edu.xmu.oneonezero.service.ArtworkService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;
/**
 * 普通管理员
 * @author DELL
 *
 */
@Controller
@RequestMapping("/admin_user")
public class AdminUserController {

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="dataDictionaryService")
	private DataDictionaryService dataDictionaryService;
	
	@Resource(name="commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@Resource(name="customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	
	@Resource(name="customizedArtworkService")
	private CustomizedArtworkService customizedArtworkService;
	
	@Resource(name="artworkOrderService")
	private ArtworkOrderService artworkOrderService;
	
	@Resource(name="artworkService")
	private ArtworkService  artworkService;

	private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 获取所有用户
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllCommonUsersAndArtist());
		return "admin_userlist";
	}
	
	/**
	 * 获取所有订单
	 * @param type 0:定制 1：制成
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping(value="/getAllOrder")
	public String getAllOrder(String type,HttpServletRequest request){
		request.setAttribute("TYPELIST", dataDictionaryService.getAllArtworkTypes());
		if(type.equals("0")){
		request.setAttribute("ORDERLIST",customizedArtworkOrderService.getAllCustomizedArtworkOrders());
		return "admin_customizedArtworkorderlist";
		}
		else {
			request.setAttribute("ORDERLIST",commodityArtworkOrderService.getAllCommodityArtworkOrders());
			return "admin_commodityArtworkorderlist";
		}
	}
	
	/**
	 * 获取所有预备艺术家
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/getAllPreparatoryArtist")
	public String getAllPreparatoryArtist(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllPreparativeArtist());
		return "admin_artistapply";
	}
	
	/**
	 * 搜索用户
	 * @param type 1:预备艺术家 2：艺术家和普通用户
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping(value="/getUser")
	public String getUser(String type,HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getUserByUserName(request.getParameter("username"),type));
		if(type.equals("2")){
		return "admin_userlist";
		}
		else return "admin_artistapply";
	}
	/**
	 * 搜索订单
	 * @param type 0:定制 1：制成
	 * @param request 请求
	 * @return String
	 * @throws ParseException 时间转换出错
	 */
	@RequestMapping(value="/getOrder")
	public String getOrder(String type,HttpServletRequest request) throws ParseException{
		String sign=request.getParameter("sign");//1:订单编号 2：艺术品名 3：卖家用户名 4：买家用户名
		String name=request.getParameter("username");
		String typeId=request.getParameter("typeId");
		String startTime=request.getParameter("txtDate time1");
		String endTime=request.getParameter("txtDate time2");
		request.setAttribute("TYPELIST", dataDictionaryService.getAllArtworkTypes());
		Date start,end;
		if(startTime==null||startTime.equals("")){
    		start=null;
    	}else {
			start=format.parse(startTime);
		}
    	if(endTime==null||endTime.equals("")){
    		end=null;
    	}else {
    		end=format.parse(endTime);
		}
    	System.out.println("type"+type);
		if(type.equals("0")){
			request.setAttribute("ORDERLIST",customizedArtworkOrderService.getByOrderIdOrArtworkNameOrOwnerNameOrUserName(sign, name, typeId, start, end));
			return "admin_customizedArtworkorderlist";
		}
		else {
			request.setAttribute("ORDERLIST",commodityArtworkOrderService.getByOrderIdOrArtworkNameOrOwnerNameOrUserName(sign, name, typeId,start, end));
			return "admin_commodityArtworkorderlist";
		}
	}
	
	/**
	 * 获取所有艺术品
	 * @param type 0:定制 1：制成
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/getAllArtwork")
	public String getAllCommodityArtwork(String type,HttpServletRequest request){
		request.setAttribute("TYPELIST",dataDictionaryService.getAllArtworkTypes());
		if(type.equals("1")){ 
			request.setAttribute("ITEMLIST",commodityArtworkService.getAllCommodityArtworks());
			return "admin_commodityitem";
		}
		else {
			request.setAttribute("ITEMLIST", customizedArtworkService.getAllCustomizedArtworks());
			return "admin_customizeditem";
		}
	}
	/**
	 * 搜索艺术品
	 * @param type 0:定制 1：制成
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/getArtwork")
	public String getCommodityArtwork(String type,HttpServletRequest request){
		String sign=request.getParameter("sign");//0：根据艺术品名称，1：根据卖家用户名
		String name=request.getParameter("username");//模糊
		String typeId=request.getParameter("typeId");//空值，表不做限制
		System.out.println("type="+type);
		request.setAttribute("TYPELIST", dataDictionaryService.getAllArtworkTypes());
		if(type.equals("1")){
		request.setAttribute("ITEMLIST",commodityArtworkService.getByVagueArtworkNameOrOwnerName(sign, name, typeId));
		return "admin_commodityitem";
		}
		else{
			request.setAttribute("ITEMLIST",customizedArtworkService.getByCustomizedArtworkNameOrOwnerId(sign, name, typeId));
			return "admin_customizeditem";
		}
	}
	
	/**
	 * 删除用户
	 * @param userId 用户id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/delUser")
	public String delUser(Long userId,HttpServletRequest request){
		userService.setUserState(userId,false);
		return "redirect:/admin_user/getAllUser";
	}
	
	/**
	 * 开启用户
	 * @param userId 用户id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/startUsing")
	public String startUsing(Long userId,HttpServletRequest request){
		userService.setUserState(userId,true);
		return "redirect:/admin_user/getAllUser";
	}
	
	/**
	 * 审核艺术家
	 * @param userId 用户id
	 * @param type 1：艺术家 0：普通用户
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping(value="/exmineArtist")
	public String exmineArtist(Long userId,String type,HttpServletRequest request){
		System.out.println("审核："+type);
		User user=userService.getUser(userId);
		DataDictionary dataDictionary;
		if(type.equals("1")){
			dataDictionary=dataDictionaryService.getDataDictionaryByName("艺术家");
		}
		else {
			dataDictionary=dataDictionaryService.getDataDictionaryByName("普通用户");
			user.setNoPassReason(request.getParameter("reason"));
		}
		user.setRole(dataDictionary);
		userService.updateUser(user);
		return "redirect:/admin_user/getAllPreparatoryArtist";
	}
}