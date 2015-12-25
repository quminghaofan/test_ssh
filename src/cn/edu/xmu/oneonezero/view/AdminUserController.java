package cn.edu.xmu.oneonezero.view;

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
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllCommonUsersAndArtist());
		return "admin_userlist";
	}
	
	@RequestMapping(value="/getAllOrder")
	public String getAllOrder(String type,HttpServletRequest request){//type:0:定制 1：制成
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
	
	@RequestMapping("/getAllPreparatoryArtist")
	public String getAllPreparatoryArtist(HttpServletRequest request){
		request.setAttribute("USERLIST", userService.getAllPreparativeArtist());
		return "admin_artistapply";
	}
	
	@RequestMapping(value="/getUser")
	public String getUser(String type,HttpServletRequest request){//1:预备艺术家 2：艺术家和普通用户
		request.setAttribute("USERLIST", userService.getUserByUserName(request.getParameter("username"),type));
		if(type.equals("2")){
		return "admin_userlist";
		}
		else return "admin_artistapply";
	}
	@RequestMapping(value="/getOrder")
	public String getOrder(String type,HttpServletRequest request) throws ParseException{//type:0:定制 1：制成
		String sign=request.getParameter("sign");//1:订单编号 2：艺术品名 3：卖家用户名 4：买家用户名
		String name=request.getParameter("username");
		String typeId=request.getParameter("type");
		String startTime=request.getParameter("txtDate time1");
		String endTime=request.getParameter("txtDate time2");
		if(type.equals("0")){
//			request.setAttribute("ORDERLIST",customizedArtworkOrderService.getByOrderIdOrArtworkNameOrOwnerNameOrUserName(sign, name, typeId, startTime, endTime));
			return "admin_customizedArtworkorderlist";
		}
		else {
			request.setAttribute("ORDERLIST",commodityArtworkOrderService.getByOrderIdOrArtworkNameOrOwnerNameOrUserName(sign, name, typeId,format.parse(startTime), format.parse(endTime)));
			return "admin_commodityArtworkorderlist";
		}
	}
	
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
	
	@RequestMapping("/getArtwork")
	public String getCommodityArtwork(String type,HttpServletRequest request){
		String sign=request.getParameter("sign");//0：根据艺术品名称，1：根据卖家用户名
		String name=request.getParameter("username");//模糊
		String typeId=request.getParameter("type");//空值，表不做限制
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
	
	@RequestMapping("/delUser")
	public String delUser(Long userId,HttpServletRequest request){
		userService.setUserState(userId,false);
		return "redirect:/admin_user/getAllUser";
	}
	
	@RequestMapping("/startUsing")
	public String startUsing(Long userId,HttpServletRequest request){
		userService.setUserState(userId,true);
		return "redirect:/admin_user/getAllUser";
	}
	
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