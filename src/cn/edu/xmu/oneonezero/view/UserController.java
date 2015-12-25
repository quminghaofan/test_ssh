package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.AccountService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	@Resource(name="customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	@Resource(name="accountService")
	private AccountService accountService;
	
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("orderList",commodityArtworkOrderService.getCommodityArtworkOrdersByUserId(user.getId()));
		return "user_order";
	}
	
	@RequestMapping("/myCustomized")
	public String myCustomized(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("orderlist",customizedArtworkOrderService.getCustomizedArtworkOrdersByUserId(user.getId()));
		return "user_customizedorder";
	}
	
	@RequestMapping("/goToOrderPay")
	public String goToOrderPay(Long orderId,String type,String stage,HttpServletRequest request){
		request.setAttribute("total", request.getParameter("total"));
		request.setAttribute("picUrl", "/test_ssh/user/myOrderPayment?orderId="+orderId+"&type="+type+"&stage="+stage);
		return "payment_login";
	}
	
	@RequestMapping("/myOrderPayment")
	public String myOrderPayment(Long orderId,String type,String stage,HttpServletRequest request){
		String total = request.getParameter("price");
		String name = request.getParameter("username");
		String psw = request.getParameter("psw");
		int pay=accountService.payMoney(name, psw,Double.parseDouble(total));
		if (pay==1) {
			if(type.equals("1")){
			commodityArtworkOrderService.updateCommodityArtworkOrderState(orderId, "已支付未发货");
			}else {
				System.out.println("!null:"+stage);
				if(stage!=null){
					System.out.println("null:"+stage);
				customizedArtworkOrderService.updateCustomizedArtworkOrderStage(orderId, stage);
				}
			}
			return "pay_success";
		} else {
			request.setAttribute("result",pay);
			request.setAttribute("total", request.getParameter("total"));
			request.setAttribute("picUrl", "/test_ssh/user/myOrderPayment?orderId="+orderId+"&type="+type+"&stage="+stage);
			return "payment_login";
		}
	}
	
	@RequestMapping("/cancelOrder")
	public String cancelOrder(Long orderId,String type,HttpServletRequest request){
		if(type.equals("1")){
			//TODO 删除成品
		    return "redirect:/user/myOrder";
		}
		else {
			//TODO 删除订制品
			return "redirect:/user/myCustomized";
		}
	}
	
	@RequestMapping("/getItem")
	public String getItem(Long orderId,String type,HttpServletRequest request) {
		if(type.equals("1")){
			commodityArtworkOrderService.updateCommodityArtworkOrderState(orderId, "已发货已支付");
			return "redirect:/user/myOrder";
		}
		else {
			customizedArtworkOrderService.updateCustomizedArtworkOrderState(orderId, "已支付已收货");
			return "redirect:/user/myCustomized";
		}
	}
}
