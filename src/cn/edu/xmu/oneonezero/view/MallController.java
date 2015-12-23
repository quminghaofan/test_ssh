package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;

@Controller
@RequestMapping("/mall")
public class MallController {
	@Resource(name = "commodityArtworkService")
	CommodityArtworkService commodityArtworkService;

	@Resource(name = "commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;

	@RequestMapping(value = "/enterMall")
	public String enterMall(String page, Long typeId, HttpServletRequest request) {
		String itemname = request.getParameter("itemname");
		System.out.println("itemname:" + itemname);
		if (itemname != null && !itemname.equals("商品名称")) {
			request.setAttribute("itemname", itemname);
		} else {
			itemname = "";
		}

		int curentPage;
		if (page == null) {
			curentPage = 1;
			request.getSession().setAttribute("pageTimes", 30);
		} else {
			curentPage = Integer.parseInt(page);
		}

		List<CommodityArtwork> commodityArtworks = null;// TODO
		if (typeId == null)
			commodityArtworks = commodityArtworkService
					.getCommodityArtworksByPositionAndVagueName(itemname,
							curentPage - 1, 30);
		else {
			// commodityArtworks
		}
		// String sort=request.getParameter("sort");
		// request.setAttribute("status", sort);
		// if(sort==null||sort.equals("0")){
		// commodityArtworks=commodityArtworkService.getCommodityArtworksByPositionAndVagueName(itemname,curentPage
		// - 1, 30);
		// }
		// else if(sort.equals("1")){
		// commodityArtworks=commodityArtworkService.getCommodityArtworksByVagueArtNameInAscendingOrder(itemname);
		// }
		// else{
		// commodityArtworks=commodityArtworkService.getCommodityArtworksByVagueArtNameInDescendingOrder(itemname);
		// }
		request.setAttribute("itemlist", commodityArtworks);
		int pageTimes = commodityArtworkService.getPageTotalByVagueName(
				itemname, 30);
		request.setAttribute("totalpage", pageTimes);
		request.getSession().setAttribute("pageTimes", pageTimes);
		request.setAttribute("currentPage", curentPage);
		return "mall";
	}

	@RequestMapping("/settle")
	public String settle(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		List<CommodityArtwork> commodityArtworks = CommonMethod
				.jsonToCommodityArtwork(request);
		Double total = 0.0;
		// System.out.println("commodityArtworks.size:"+commodityArtworks.size());
		for (CommodityArtwork commodityArtwork : commodityArtworks) {
			total += commodityArtwork.getPrice();
		}
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", total);
		request.setAttribute("type", 0);
		return "checkorder";
	}

	@RequestMapping("/settleOne")
	public String settleOne(Long itemId, HttpServletResponse response,
			HttpServletRequest request) throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		List<CommodityArtwork> commodityArtworks = new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork = null;// TODO
		commodityArtworks.add(commodityArtwork);
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", commodityArtwork.getPrice());
		request.setAttribute("type", itemId);
		return "checkorder";
	}

	@RequestMapping("/seeMore")
	public String seeMore(long itemId, HttpServletRequest request) {
		request.setAttribute("item", commodityArtworkService
				.getCommodityArtworkWithJSONTypeById(itemId));
		return "item";
	}

	@RequestMapping("/goToPay")
	public String goToPay(Long type, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		List<CommodityArtworkOrder> commodityArtworkOrders= new ArrayList<CommodityArtworkOrder>();
		if (type == 0) {
			List<CommodityArtwork> commodityArtworks = CommonMethod.jsonToCommodityArtwork(request); 
			for (CommodityArtwork commodityArtwork : commodityArtworks) {
				CommodityArtworkOrder commodityArtworkOrder = new CommodityArtworkOrder();
				commodityArtworkOrder.setCommodityArtwork(commodityArtwork);
				// commodityArtworkOrder.setPrice(commodityArtwork.getPrice());
				// TODO price属性可以去掉
				commodityArtworkOrder.setUser(user);
				commodityArtworkOrder.setAddress(user.getAddress());
				commodityArtworkOrder.setMobile(user.getMobile());
				commodityArtworkOrder.setPlaceDate(new Date(System
						.currentTimeMillis()));
				commodityArtworkOrder.setState("未支付");
				commodityArtworkOrders.add(commodityArtworkOrder);
			}
			//TODO 添加
			CommonMethod.cleanCookie(request, response);
		} else {
			CommodityArtwork commodityArtwork=null;//TODO 根据id-type获取
			CommodityArtworkOrder commodityArtworkOrder = new CommodityArtworkOrder();
			commodityArtworkOrder.setCommodityArtwork(commodityArtwork);
			// commodityArtworkOrder.setPrice(commodityArtwork.getPrice());
			// TODO price属性可以去掉
			commodityArtworkOrder.setUser(user);
			commodityArtworkOrder.setAddress(user.getAddress());
			commodityArtworkOrder.setMobile(user.getMobile());
			commodityArtworkOrder.setPlaceDate(new Date(System
					.currentTimeMillis()));
			commodityArtworkOrder.setState("未支付");
			commodityArtworkOrders.add(commodityArtworkOrder);
			//TODO 添加
		}
		request.getSession().setAttribute("commodityArtworkOrders", commodityArtworkOrders);
		return "";// 输入账号界面
	}

	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response) {
		request.getAttribute("");
		if(true){//支付成功
			List<CommodityArtworkOrder> commodityArtworkOrders=(ArrayList<CommodityArtworkOrder>)request.getSession().getAttribute("commodityArtworkOrders");
			for(CommodityArtworkOrder commodityArtworkOrder:commodityArtworkOrders){
				//更新订单状态，根据id
			}
			return "pay_success";
		}
		else {
			//支付失败，进入输入账号界面
			return "";
		}
	}

	@RequestMapping("/editOrder")
	public String editOrder(String wh,Long type, String address, String mobile,
			HttpServletRequest request) {
		request.getSession().setAttribute("address", address);
		request.setAttribute("type", type);
		if (wh.equals("0")) {
			request.getSession().setAttribute("mobile", mobile);
			return "order_edit";
		} else {
			return "redirect:/mall/goBack?type="+type;
		}
	}
	
	@RequestMapping("/goBack")
	public String goBack(Long type,HttpServletRequest request){
		if(type==0){
			return "redirect:/mall/settle";
		}
		else {
			return "redirect:/mall/settleOne?itemId="+type;
		}
	}
}
