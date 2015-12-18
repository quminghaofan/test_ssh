package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;

@Controller
@RequestMapping("/mall")
public class MallController {
	@Resource(name = "commodityArtworkService")
	CommodityArtworkService commodityArtworkService;

	@RequestMapping(value="/enterMall")
	public String enterMall(String page,HttpServletRequest request) {
		String itemname=request.getParameter("itemname");
		System.out.println("itemname:"+itemname);
		if(itemname!=null&&!itemname.equals("商品名称")){
			request.setAttribute("itemname", itemname);
		}
		else {
			itemname="";
		}
		
		int curentPage;
		if (page == null) {
			curentPage = 1;
			request.getSession().setAttribute("pageTimes", 30);
		} else {
			curentPage = Integer.parseInt(page);
		}
		
		List<CommodityArtwork> commodityArtworks;
		String sort=request.getParameter("sort");
		request.setAttribute("status", sort);
		if(sort==null||sort.equals("0")){
			commodityArtworks=commodityArtworkService.getCommodityArtworksByPositionAndVagueName(itemname,curentPage - 1, 30);
		}
		else if(sort.equals("1")){
			commodityArtworks=commodityArtworkService.getCommodityArtworksByVagueArtNameInAscendingOrder(itemname);
		}
		else{
			commodityArtworks=commodityArtworkService.getCommodityArtworksByVagueArtNameInDescendingOrder(itemname);
		}
		request.setAttribute("itemlist",commodityArtworks);
		int pageTimes = commodityArtworkService.getPageTotalByVagueName(itemname,30);
		request.setAttribute("totalpage", pageTimes);
		request.getSession().setAttribute("pageTimes", pageTimes);
		request.setAttribute("currentPage", curentPage);
		return "mall";
	}

	@RequestMapping("/settle")
	public String settle(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		List<CommodityArtwork> commodityArtworks = CommonMethod.jsonToFinishedItem(request);
		Double total = 0.0;
		// System.out.println("commodityArtworks.size:"+commodityArtworks.size());
		for (CommodityArtwork commodityArtwork : commodityArtworks) {
			total += commodityArtwork.getPrice();
		}
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", total);
		return "checkorder";
	}
	
	@RequestMapping("/settleOne")
	public String settleOne(Long itemId,HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException{
		List<CommodityArtwork> commodityArtworks=new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork=null;
		commodityArtworks.add(commodityArtwork);
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", commodityArtwork.getPrice());
		return "checkorder";
	}

	@RequestMapping("/seeMore")
	public String seeMore(long itemId, HttpServletRequest request) {
		request.setAttribute("item", commodityArtworkService.getCommodityArtworkWithJSONTypeById(itemId));
		return "item";
	}

	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response) {
		request.getAttribute("");
		CommonMethod.cleanCookie(request, response);
		return "pay_success";
	} 
}
