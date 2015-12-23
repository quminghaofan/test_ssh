package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("artist")
public class ArtistController {
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="dataDictionaryService")
	private DataDictionaryService dataDictionaryService;
	
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@Resource(name="commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	
	@Resource(name="customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	
	@RequestMapping("/artistApply")
	public String artistApply(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		user.setBankCardAccount(request.getParameter("account"));
		DataDictionary dataDictionary=dataDictionaryService.getDataDictionaryByName("预备艺术家");
		user.setRole(dataDictionary);
		user.setRealName(request.getParameter("realname"));
		userService.updateUser(user);
		request.getSession().setAttribute("user", user);
		return "redirect:/init/home";
	}
	
	@RequestMapping("/myArt")
	public String myArtWork(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("commodityArtworkList",commodityArtworkService.getCommodityArtworksByArtistId(user.getId()));
		return "artist_shop";
	}
	
	@RequestMapping("/mySale")
	public String mySale(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("orderList",commodityArtworkOrderService.getCommodityArtworkOrdersByArtistId(user.getId()));
		return "artist_saleorder";
	}
	
	@RequestMapping("myCustomized")
	public String myCustomized(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("orderList",customizedArtworkOrderService.getCustomizedArtworkOrdersByOwnerId(user.getId()));
		return "artist_customizedorder";
	}
	@RequestMapping("/goToEdit")
	public String goToEdit(Long itemid,HttpServletRequest request){
		CommodityArtwork commodityArtwork=commodityArtworkService.getCommodityArtworkById(itemid);
		request.setAttribute("item", commodityArtwork);
		request.setAttribute("TYPELIST",dataDictionaryService.getAllArtworkTypes());
		return "artwork_edit";
	}
	
	@RequestMapping("customizedorderDetail")
	public String customizedorderDetail(Long orderId,HttpServletRequest request){
		request.setAttribute("order",customizedArtworkOrderService.getCustomedArtworkOrderByOrderId(orderId));
		return "artist_customizedorder_detail";
	}
	
	@ResourceMapping("/editOrAddArtwork")
	public String editOrAddArtwork(Long itemId,HttpServletRequest request){
		String picUrl=request.getParameter("img");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		DataDictionary dataDictionary=dataDictionaryService.getDataDictionaryByName(type);
		String model=request.getParameter("select2");
		boolean canSell;
		if(model.equals("1"))canSell=false;
		else {
			canSell=true;
		}
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		if(itemId==null){
			CommodityArtwork commodityArtwork=new CommodityArtwork();
			commodityArtwork.setPicUrl(picUrl);
			commodityArtwork.setName(name);
			commodityArtwork.setType(dataDictionary);
			commodityArtwork.setCanSell(canSell);
			commodityArtwork.setPrice(Double.parseDouble(price));
			commodityArtwork.setArtworkDescription(description);
			commodityArtworkService.insertCommodityArtwork(commodityArtwork);
		}
		else {
			CommodityArtwork commodityArtwork=commodityArtworkService.getCommodityArtworkById(itemId);
			commodityArtwork.setPicUrl(picUrl);
			commodityArtwork.setName(name);
			commodityArtwork.setType(dataDictionary);
			commodityArtwork.setCanSell(canSell);
			commodityArtwork.setPrice(Double.parseDouble(price));
			commodityArtwork.setArtworkDescription(description);
			commodityArtworkService.updateCommodityArtwork(commodityArtwork);
		}
		return "redirect:/artist/myArt";
	}
	
	@RequestMapping("delArtwork")
	public String delArtwork(Long itemId,HttpServletRequest request){
//		commodityArtworkService.
		return "redirect:/artist/myArt";
	}
}
