package cn.edu.xmu.oneonezero.view;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.log.Log;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/customized")
public class CustomizedController {
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="customizedArtworkService")
	private CustomizedArtworkService customizedArtworkService;
	
	@Resource(name="dataDictionaryService")
	private DataDictionaryService dataDictionaryService;
	
	@Resource(name="customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	
	@Resource(name="commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;
	
	@RequestMapping("seeMore")
	public String seeMore(Long artistId,HttpServletRequest request){
		request.setAttribute("artist",userService.getUser(artistId));
		request.setAttribute("artCommodList",
				commodityArtworkService.getExhibitArtworksByOwnerId(artistId));
		return "artistInfoAndCommondity";
	}
	
	@RequestMapping("/goToCustomizationApplying")
	public String goToCustomizationApplying(Long artistId,HttpServletRequest request){
		request.setAttribute("TYPELIST", dataDictionaryService.getAllArtworkTypes());
		request.setAttribute("artistId", artistId);
		return "customizeArt";
	}
	
	@RequestMapping("/customizationApplying")
	public String customizationApplying(@RequestParam(value = "img", required = false) MultipartFile filedata,Long artistId,HttpServletRequest request){
		User artist=userService.getUser(artistId);
		User user=(User)request.getSession().getAttribute("user");

		String path = CommonMethod.getPicUrl(request);
		String picurl=PicUpload.saveFile(filedata,path);
		
		CustomizedArtwork customizedArtwork=new CustomizedArtwork();
		DataDictionary dataDictionary=dataDictionaryService.getDataDictionaryByName(request.getParameter("arttype"));
		customizedArtwork.setType(dataDictionary);
		customizedArtwork.setName(request.getParameter("artname"));
		customizedArtwork.setOwner(artist);
		customizedArtworkService.insertCustomizedArtwork(customizedArtwork);
		System.out.println("定制-添加艺术品："+path+":"+dataDictionary.getName());
		CustomizedArtworkOrder customizedArtworkOrder=new CustomizedArtworkOrder();
		customizedArtworkOrder.setMobile(request.getParameter("telephone"));
		customizedArtworkOrder.setAddress(request.getParameter("address"));
		customizedArtworkOrder.setOrderId(Long.toString(System.currentTimeMillis()));
		customizedArtworkOrder.setCustomizedArtwork(customizedArtwork);
		customizedArtworkOrder.setPlaceDate(new java.sql.Date(new Date().getTime()));
		customizedArtworkOrder.setUser(user);
		customizedArtworkOrder.setState("未支付");
		customizedArtworkOrder.setNeedDescription(request.getParameter("intro"));
		customizedArtworkOrder.setDemoPic(picurl);
		customizedArtworkOrderService.insertCustomizedArtworkOrder(customizedArtworkOrder);
		return "redirect:/mall/enterMall?go=0";
	}
	
	@RequestMapping("/goBack")
	public String goBack(Long artistId,HttpServletRequest request){
		if(artistId==null){
			return "redirect:/mall/enterMall?go=0";
		}
		return "redirect:/customized/seeMore?artistId="+artistId;
	}

}
