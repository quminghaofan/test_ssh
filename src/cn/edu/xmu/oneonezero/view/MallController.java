package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;

@Controller
@RequestMapping("/mall")
public class MallController {
	@Resource(name = "commodityArtworkService")
	CommodityArtworkService commodityArtworkService;

	@RequestMapping("/enterMall")
	public String enterMall(String page, HttpServletRequest request) {
		request.getSession().setAttribute("pageTimes", 30);
		String itemname=request.getParameter("itemname");
		if(itemname!=null&&!itemname.equals("商品名称")){
			request.setAttribute("itemname", itemname);
		}
		else {
			itemname="";
		}
		
		int curentPage;
		if (page == null) {
			curentPage = 1;
		} else {
			curentPage = Integer.parseInt(page);
		}
		
		String sort=request.getParameter("sort");
		request.setAttribute("status", sort);
		if(sort==null||sort.equals("0")){
			request.setAttribute("itemlist", commodityArtworkService
					.getCommodityArtworksByPosition(/*itemname,*/curentPage - 1, 30));
		}
		else if(sort.equals("1")){
			
		}
		else{
			
		}
		int pageTimes = commodityArtworkService.getPageTotal(/*itemname,*/30);
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
		CommonMethod.cleanCookie(request, response);
		return "checkorder";
	}

	@RequestMapping("/seeMore")
	public String seeMore(long itemId, HttpServletRequest request) {

		return "item";
	}

	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response) {
		CommonMethod.cleanCookie(request, response);
		return "pay_success";
	} 
}
