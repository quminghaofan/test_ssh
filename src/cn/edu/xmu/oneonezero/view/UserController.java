package cn.edu.xmu.oneonezero.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
//	@Qualifier("")
//	private 
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有成品订单
//		request.setAttribute("orderList", arg1);
		return "user_order";
	}
	
	@RequestMapping("/myCustomized")
	public String myCustomized(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有定制订单
		return "user_customizedorder";
	}
	
	@RequestMapping("/myOrderPayment")
	public String myOrderPayment(Long orderId,String type,HttpServletRequest request){
		if(type.equals("1")){
			//根据id获取成品订单
		}
		else {
			//根据id获取艺术品订单
		}
		//TODO 支付
		return "pay_success";
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
