package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.AccountService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;

@Controller
@RequestMapping("/mall")
public class MallController {
	@Resource(name = "commodityArtworkService")
	CommodityArtworkService commodityArtworkService;

	@Resource(name = "commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;

	@Resource(name = "customizedArtworkService")
	private CustomizedArtworkService customizedArtworkService;

	@Resource(name = "accountService")
	private AccountService accountService;

	@RequestMapping(value = "/enterMall")
	public String enterMall(String page, String go, Long typeId,
			HttpServletRequest request) {
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
		} else {
			curentPage = Integer.parseInt(page);
		}
		int pageTimes;
		request.setAttribute("currentPage", curentPage);
		request.setAttribute("typeId", typeId);
		System.out.println("购物：" + go);
		if (go.equals("1")) {
			pageTimes = commodityArtworkService.getPageTotalByVagueName(
					itemname, 30);
			request.setAttribute("totalpage", pageTimes);
			request.getSession().setAttribute("pageTimes", pageTimes);
			if (typeId == null) {
				request.setAttribute("itemlist", commodityArtworkService
						.getCommodityArtworksByPositionAndVagueName(itemname,
								curentPage - 1, 30));
			} else {
				request.setAttribute(
						"itemlist",
						commodityArtworkService
								.getCommodityArtworksByArtworkTypeIdVagueArtworkNamePageNumber(
										typeId, itemname, curentPage - 1, 30));
			}
			return "mall";
		} else {
			pageTimes = commodityArtworkService.getExhibitPageTotalByVagueName(
					itemname, 30);
			request.setAttribute("totalpage", pageTimes);
			request.getSession().setAttribute("pageTimes", pageTimes);
			if (typeId == null) {
				request.setAttribute("itemlist", commodityArtworkService
						.getExhibitArtworksByVagueArtNameAndPage(itemname,
								curentPage - 1, 30));
			} else {
				request.setAttribute(
						"itemlist",
						commodityArtworkService
								.getExhibitArtworksByArtworkTypeIdVagueArtworkNamePageNumber(
										typeId, itemname, curentPage - 1, 30));
			}
			return "customized";
		}
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
		List<CommodityArtwork> commodityArtworks = new ArrayList<CommodityArtwork>();
		CommodityArtwork commodityArtwork = commodityArtworkService
				.getCommodityArtworkById(itemId);
		if (commodityArtwork != null) {
			commodityArtworks.add(commodityArtwork);
		}
		request.setAttribute("orderlist", commodityArtworks);
		request.setAttribute("total", commodityArtwork.getPrice());
		request.setAttribute("type", itemId);
		System.out.println("itemId:" + itemId);
		return "checkorder";
	}

	@RequestMapping("/seeMore")
	public String seeMore(long itemId, HttpServletRequest request) {
		request.setAttribute("item", commodityArtworkService
				.getCommodityArtworkWithJSONTypeById(itemId));
		return "item";
	}

	@RequestMapping("/goToPay")
	public String goToPay(Long type, String total, HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		User user = (User) request.getSession().getAttribute("user");
		List<CommodityArtworkOrder> commodityArtworkOrders = new ArrayList<CommodityArtworkOrder>();
		System.out.println("type:" + type);
		if (type == 0) {
			List<CommodityArtwork> commodityArtworks = CommonMethod
					.jsonToCommodityArtwork(request);
			for (CommodityArtwork commodityArtwork : commodityArtworks) {
				CommodityArtworkOrder commodityArtworkOrder = new CommodityArtworkOrder();
				commodityArtworkOrder.setOrderId(Long.toString(System
						.currentTimeMillis()));
				commodityArtworkOrder.setCommodityArtwork(commodityArtwork);
				commodityArtworkOrder.setUser(user);
				commodityArtworkOrder.setAddress(user.getAddress());
				commodityArtworkOrder.setMobile(user.getMobile());
				commodityArtworkOrder.setPlaceDate(new Date(System
						.currentTimeMillis()));
				commodityArtworkOrder.setState("未支付");
				commodityArtworkOrders.add(commodityArtworkOrder);
			}
			commodityArtworkOrderService
					.insertSomeCommodityArtworkOrders(commodityArtworkOrders);
			CommonMethod.cleanCookie(request, response);
		} else {
			CommodityArtwork commodityArtwork = commodityArtworkService
					.getCommodityArtworkById(type);
			CommodityArtworkOrder commodityArtworkOrder = new CommodityArtworkOrder();
			commodityArtworkOrder.setOrderId(Long.toString(System
					.currentTimeMillis()));
			commodityArtworkOrder.setCommodityArtwork(commodityArtwork);
			commodityArtworkOrder.setUser(user);
			commodityArtworkOrder.setAddress(user.getAddress());
			commodityArtworkOrder.setMobile(user.getMobile());
			commodityArtworkOrder.setPlaceDate(new Date(System
					.currentTimeMillis()));
			commodityArtworkOrder.setState("未支付");
			commodityArtworkOrders.add(commodityArtworkOrder);
			 System.out.println("添加一个");
			commodityArtworkOrderService.insertCommodityArtworkOrder(commodityArtworkOrder);
		}
		request.getSession().setAttribute("commodityArtworkOrders",
				commodityArtworkOrders);
		// System.out.print("total:"+request.getParameter("total"));
		request.setAttribute("total", total);
		request.setAttribute("picUrl", "/test_ssh/mall/pay");
		return "payment_login";
	}

	@RequestMapping("/pay")
	public String pay(HttpServletRequest request, HttpServletResponse response) {
		String total = request.getParameter("price");
		String name = request.getParameter("username");
		String psw = request.getParameter("psw");
		int pay = accountService.payMoney(name, psw, Double.parseDouble(total));
		if (pay == 1) {
			List<CommodityArtworkOrder> commodityArtworkOrders = (List<CommodityArtworkOrder>) request.getSession().getAttribute("commodityArtworkOrders");
			System.out.println("comOrder-size:"+commodityArtworkOrders.size());
				for (CommodityArtworkOrder commodityArtworkOrder : commodityArtworkOrders) {
					// System.out.println("commodityArtworkOrderId:"+commodityArtworkOrder.getId());
					commodityArtworkOrderService
							.updateCommodityArtworkOrderState(
									commodityArtworkOrder.getId(), "已支付未发货");
				}
			return "pay_success";
		} else {
			request.setAttribute("result", pay);
			request.setAttribute("total", total);
			request.setAttribute("picUrl", "/test_ssh/mall/pay");
			return "payment_login";
		}
	}

	@RequestMapping("/editOrder")
	public String editOrder(String wh, Long type, String address,
			String mobile, HttpServletRequest request) {
		System.out.println("editorder:wh=" + wh + ",type=" + type + ",address="
				+ address + ",mobil=" + mobile);
		request.setAttribute("type", type);
		HttpSession session = request.getSession();
		if (wh.equals("0")) {
			session.setAttribute("address", address);
			session.setAttribute("mobile", mobile);
			return "order_edit";
		} else {
			session.setAttribute("address", request.getParameter("addre"));
			session.setAttribute("mobile", request.getParameter("phone"));
			return "redirect:/mall/goBack?type=" + type;
		}
	}

	@RequestMapping("/goBack")
	public String goBack(Long type, HttpServletRequest request) {
		System.out.println("goback-type:" + type);
		if (type == 0) {
			return "redirect:/mall/settle";
		} else {
			return "redirect:/mall/settleOne?itemId=" + type;
		}
	}
}
