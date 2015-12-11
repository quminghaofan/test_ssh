package cn.edu.xmu.oneonezero.view;

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
	@Resource(name="commodityArtworkService")
	CommodityArtworkService commodityArtworkService;
	@RequestMapping("/enterMall")
	public String enterMall(HttpServletRequest request){
		int page=Integer.parseInt(request.getParameter(""));
		request.setAttribute("max_page", commodityArtworkService.getPageTotal(30));
		request.setAttribute("current_page", page);
		request.setAttribute("itemlist",commodityArtworkService.getCommodityArtworksByPosition(page-1, 30));
		return "mall";
	}
	
	@RequestMapping("/settle")
	public String settle(HttpServletRequest request,HttpServletResponse response){
		List<CommodityArtwork> commodityArtworks=CommonMethod.jsonToFinishedItem(request);
		Double total=0.0;
		System.out.println("commodityArtworks.size:"+commodityArtworks.size());
		for(CommodityArtwork commodityArtwork:commodityArtworks){
			total+=commodityArtwork.getPrice();
			System.out.println("total1:"+total);
		}
//		System.out.println(total);
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("username",user.getName());
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", total);
//		CommonMethod.cleanCookie(request, response);
		return "checkorder";
	}
	
	@RequestMapping("/seeMore")
	public String seeMore(long itemId,HttpServletRequest request){
		
		return "item";
	}
}
