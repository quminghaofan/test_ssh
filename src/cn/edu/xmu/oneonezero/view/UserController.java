package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Qualifier("commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	@Resource(name="customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		request.setAttribute("orderList",commodityArtworkOrderService.getCommodityArtworkOrdersByUserId(user.getId()));
		return "user_order";
	}
	
	@RequestMapping("/myCustomized")
	public String myCustomized(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有定制订单
		request.setAttribute("order",customizedArtworkOrderService.getCustomizedArtworkOrdersByUserId(user.getId()));
		return "user_customizedorder";
	}
	
	@RequestMapping("/myOrderPayment")
	public String myOrderPayment(Long orderId,String type,HttpServletRequest request){
		request.getAttribute("");
		if(true){//支付成功
			if(type.equals("1")){
				//更新订单状态，根据id成品订单
			}
			else {
				//更新订单状态，根据id定制订单
			}
			//
			return "pay_success";
		}
		else {
			//支付失败，进入输入账号界面
			return "";
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
}
