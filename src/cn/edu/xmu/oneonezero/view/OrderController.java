package cn.edu.xmu.oneonezero.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.User;

@Controller
@RequestMapping("/order")
public class OrderController {
//	@Qualifier("")
//	private 
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		//TODO 根据用户id获取所有订单
//		request.setAttribute("orderList", arg1);
		return "user_order";
	}
}
